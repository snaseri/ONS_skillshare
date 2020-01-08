package uk.ac.cf.cs.ons.skillsdb.skillsdb.architecture;


import org.springframework.ui.Model;

import javax.swing.text.ComponentView;

public class GenerateModel {

    @Test
    public void generateModel() throws Exception {


        Workspace workspace = new Workspace("Charity Giving 2019", "Sample Spring Boot Project");
        Model model = workspace.getModel();

        // create the basic model (the stuff we can't get from the code)
        SoftwareSystem charityGiving = model.addSoftwareSystem("CharityGiving", "Online sponsorship system");
        Person donor = model.addPerson("Donor.", "  A person who wishes to give to Charity");
        Person participant = model.addPerson("Participant", "Person who wishes to raise money for Charity");
        Person trustee = model.addPerson("Trustee.", "  A person who works for a charity");

        donor.uses(charityGiving, "Uses");
        participant.uses(charityGiving, "Uses");
        trustee.uses(charityGiving, "Uses");


        Container webApplication = charityGiving.addContainer(
                "Spring Boot Application", "The web application", "Embedded web container.  Tomcat 7.0");
        Container relationalDatabase = charityGiving.addContainer(
                "Relational Database", "Stores information regarding the products.", "MySQL");
        donor.uses(webApplication, "Uses", "HTTP");
        participant.uses(webApplication, "Uses", "HTTP");
        trustee.uses(webApplication, "Uses", "HTTP");

        webApplication.uses(relationalDatabase, "Reads from and writes to", "JDBC, port 3306");

        // and now automatically find all Spring @Controller, @Component, @Service and @Repository components
        ComponentFinder componentFinder = new ComponentFinder(
                webApplication,
                "com.nsa.cm6213.charity2019walk",
                new SpringComponentFinderStrategy(
                        new ReferencedTypesSupportingTypesStrategy()
                ));

        /*SpringComponentFinderStrategy springComponentFinderStrategy = new SpringComponentFinderStrategy(new ReferencedTypesSupportingTypesStrategy(false));
        springComponentFinderStrategy.setIncludePublicTypesOnly(false);

        ComponentFinder componentFinder = new ComponentFinder(
                webApplication,
                "com.nsa.cm6213.charity2019walk",
                springComponentFinderStrategy,
                new SourceCodeComponentFinderStrategy(new File(sourceRoot, "/src/main/java/"), 150));
*/
        componentFinder.findComponents();

        // connect the user to all of the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> donor.uses(c, "Uses", "HTTP"));

        // connect the registration system to all of the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> participant.uses(c, "Uses", "HTTP"));

        // connect the registration system to all of the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> trustee.uses(c, "Uses", "HTTP"));

        // connect all of the repository components to the relational database
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY))
                .forEach(c -> c.uses(relationalDatabase, "Reads from and writes to", "JDBC"));

        //Let's see what is being scanned
        for (Component c : webApplication.getComponents()) {
            System.out.println(c.getRelationships());
        }

        Component cservice = webApplication.getComponentOfType("com.nsa.cm6213.charity2019walk.service.CharityQueries");

        System.out.println(cservice);

        Component cRepo = webApplication.getComponentOfType("com.nsa.cm6213.charity2019walk.data.CharityRepoJPA");
        System.out.println(cRepo);

        cservice.uses(cRepo, "uses");

        // finally create some views
        ViewSet viewSet = workspace.getViews();
        SystemContextView contextView = viewSet.createSystemContextView(charityGiving, "context", "The System Context diagram for the Charity 2018 system.");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();

        ContainerView containerView = viewSet.createContainerView(charityGiving, "containers", "The Containers diagram for the Charity 2018 system.");
        containerView.addAllPeople();
        containerView.addAllSoftwareSystems();
        containerView.addAllContainers();

        ComponentView componentView = viewSet.createComponentView(webApplication, "components", "The Components diagram for the Charity 2018 web application.");
        componentView.addAllComponents();
        componentView.addAllPeople();
        componentView.add(relationalDatabase);

        // link the architecture model with the code
        for (Component component : webApplication.getComponents()) {
            for (CodeElement codeElement : component.getCode()) {
                String sourcePath = codeElement.getUrl();
                if (sourcePath != null) {
                    codeElement.setUrl(
                            "https://gitlab.cs.cf.ac.uk/CM6213-Commercial-Applications-with-Java/cm6213-1920/charity-walkthrough/tree/master");
                }
            }
        }

        // rather than creating a component model for the database, let's simply link to the DDL
        // (this is really just an example of linking an arbitrary element in the model to an external resource)
        //relationalDatabase.setUrl("https://github.com/spring-projects/spring-petclinic/tree/master/src/main/resources/db/hsqldb");

        // tag and style some elements
        charityGiving.addTags("Charity Giving 2019");
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER)).forEach(c -> c.addTags("Spring MVC Controller"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER)).forEach(c -> c.addTags("Spring REST Controller"));

        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_SERVICE)).forEach(c -> c.addTags("Spring Service"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY)).forEach(c -> c.addTags("Spring Repository"));
        relationalDatabase.addTags("Database");


        Styles styles = viewSet.getConfiguration().getStyles();
        styles.addElementStyle("Charity Giving 2019").background("#6CB33E").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#519823").color("#ffffff").shape(Shape.Person);
        styles.addElementStyle(Tags.CONTAINER).background("#91D366").color("#ffffff");
        styles.addElementStyle("Database").shape(Shape.Cylinder);

        styles.addElementStyle("Spring REST Controller").background("#D4FFC0").color("#000000");

        styles.addElementStyle("Spring MVC Controller").background("#D4F3C0").color("#000000");
        styles.addElementStyle("Spring Service").background("#6CB33E").color("#000000");
        styles.addElementStyle("Spring Repository").background("#95D46C").color("#000000");

        StructurizrClient structurizrClient = new StructurizrClient("ced4be4f-d92a-41d0-90d5-fbf5536d63ff", "7d95450e-7f1b-4774-8890-7645bc769778");
        //structurizrClient.mergeWorkspace(41640, workspace);
        structurizrClient.putWorkspace(41640, workspace);
    }


}

