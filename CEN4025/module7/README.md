# Module 7
## Overview
 Create a to-do list application with web and database connectivity. The application must have a way to add, delete, and view the to-do list items.
## Steps Outline
1) Setup
2) Add Database Connectivity
3) Add Web Application Functionality
## Steps In-Depth
### 1. Setup
#### 1. Download Apache Tomcat using the video `Java Servlets & JSP [2] - Creating a Java Web Application` listed in Valencia Resources section of the Resources section
#### 2. Create a Jakarta EE project.
1. Template: Web application
2. Application server: Tomcat 10.1.15
3. Build system: Maven
4. JDK: 17.0.7
#### 3. Dependencies upon creation:
- [x] Web Profile
- [x] Hibernate
#### 4. Right click `pom.xml` from the project view and select `Add as Maven Project`.
### 2. Add Database Connectivity
1. Add SQL dependency in pom.xml.
2. Unload Maven changes by pressing `ctrl-shift-o`. If this doesn't work you can right click the project in the maven tool window and select reload project. CLOSE INTELLIJ AND REOPEN THE IDE. Now add the persistence tool window to the left tool window pane.
3. Add new datasource form URL in the Database(DB) tool window. Example URL `jdbc:mysql://localhost:3306/dbname`.
4. Use the persistence tool to generate persistence mapping by database schema. Choose the data source and select the appropriate table. (optional: add `<property name="hibernate.show_sql" value="true"/>` to the `persistence.xml` file to view the SQL output in the console.)
5. Create class `Main.java` in com.example.module7.
6. Copy relevant code from `Main.java` in the project `module5`.
7. Repeat step 6 for `Methods.java`.
8. Import the `ToDoListEntity.java` class into the `Main.java` class.
### 3. Add Web Application Functionality
1. Edit the run configuration and add the Tomcat server.
2. In the run configuration, add a reployment and select the `module7_war_exploded`, clear the application context and press OK.
3. Add html to the `index.jsp` file. Follow along to the video `Simple JSP Web Form - text boxes, radio buttons, drop down lists` for in-depth instructions.
4. Create a Servlet class. Refer to the resource `Stack Overflow [2]` for information on setting up a servlet template. This is only nescessary if you can't add a new servlet by default.
5. Create a form to hold the users input in the `index.jsp` file. The action should be the value in the Servlet class. 
6. Create an `EntityManagerFactory`, `EntityManager`, and `transaction` in the beginning of the `Servlet` class.

## Resources
### Valencia Resources
* [Java Servlets & JSP [2] - Creating a Java Web Application](https://www.youtube.com/watch?v=0FpLve7ffoY)
* [Simple JSP Web Form - text boxes, radio buttons, drop down lists](https://www.youtube.com/watch?v=3ITdSQ3NmXU)
### Stack Overflow
* [How do I find out my MySQL URL, host, port and username?](https://stackoverflow.com/questions/4093603/how-do-i-find-out-my-mysql-url-host-port-and-username) [1]
* [Where can i find to create new servlet file with intellij?](https://stackoverflow.com/questions/63854849/where-can-i-find-to-create-new-servlet-file-with-intellij) [2]
* [java how to use classes in other package?](https://stackoverflow.com/questions/3480389/java-how-to-use-classes-in-other-package) [3]
* [creating and persisting entities from servlets](https://stackoverflow.com/questions/16001285/creating-and-persisting-entities-from-servlets) [4]
* [doGet and doPost in Servlets](https://stackoverflow.com/questions/2349633/doget-and-dopost-in-servlets) [5]
* [How to transfer data from JSP to servlet when submitting HTML form](https://stackoverflow.com/questions/4971877/how-to-transfer-data-from-jsp-to-servlet-when-submitting-html-form) [6]
* [How can I pass value from JSP page to Servlet and save in MySQL database?](https://stackoverflow.com/questions/12634710/how-can-i-pass-value-from-jsp-page-to-servlet-and-save-in-mysql-database) [7]