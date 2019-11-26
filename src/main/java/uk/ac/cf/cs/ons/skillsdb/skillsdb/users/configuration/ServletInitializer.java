package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.configuration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.SkillsdbApplication;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SkillsdbApplication.class);
    }

}
