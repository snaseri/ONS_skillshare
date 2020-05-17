
TECHNOLOGY USED:
- First make sure you have OpenJDK 11.0.6 installed.
- IntelliJ IDE
- MySQL Workbench 8.0
How to setup:
- Clone the project
- There is a file called install.sql in the project folder
- Use that to install the database. I used MySQL workbench to do that by running all the queries inside that file, However, you may use any other way you perfer to run the queries.
- Then open project in IntelliJ and go to this directory \src\main\resources
- Open application.properties and edit the following two lines to your database username and password:
	spring.datasource.username = [YOUR USERNAME]
	spring.datasource.password = [YOUR PASSWORD]
- Using IntelliJ, open the gradle tab and 'bootRun' the project. Which is inside Tasks/application
	(Gradle tab is found and the very right handside of IntelliJ). Alternatively, you can use the 
	command line to create a jar by doing 'gradle bootJar' in the project folder then, there will be
	a jar file created inside: build/libs. Enter that directory and execute: 
	java -jar skillsdb-0.0.1-SNAPSHOT.jar to run the project. 
- The project will be up and running on this address: http://localhost:8080/ by default.
  (Note that for Vulrneability 6/HTTPS the project is running on https://localhost:8433)
