# Creating a project

1. Create in IntelliJ Maven based application based on **maven-archetype-webapp**  Archetype
 groupId is com.softserverinc.edu
 artifactId  agiledev

1. Modify **pom.xml** file for Spring MVC with no **web.xml** configuration

1. Issue command **Maven->Reimport**

1. Delete **web.xml** file

1. Create directories

      src/main/webapp/WEB-INF/resoures
      src/main/webapp/WEB-INF/layouts
      src/main/webapp/WEB-INF/views

1. Put files in above directories. These files are responsibile for web interface

1. Put file **logback.xml** in resources directory

1. In **main** directory create packages  java.com.softserverinc.edu

1. In **edu** package create packages
      **config**

1. Make directory **java**  as Sources Root

1. In **config** package create classes
     **WebAppInitializer**
     **WebConfig**
     
1. Delete file src/main/webapp/index.jsp

1. Create local server Tomcat
    1. Add Deployment agiledev:war exploded
	1. Remove a folder there if it exists
	1. Add in Before lunch: Build agiledev:war exploded artifact

1. Go to in main menu  File->Project Structure->Artifacts.
   Click right on **agiledev:war exploded**
   Double click right on **WEB-INF** folder to open it than on **+** sign and choose **Directory Content** and choose **WEB-INF** folder. This will include WEB-INF subfolders in war file