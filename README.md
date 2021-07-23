# Story Pitch Management System - README

### Matt Anderson - 2105 Java w/MSA - Project 1

> This Project was completed to fulfill the requirements of Project 1 during Training at Revature LLC.
>
> The client was looking for a Web Application with which to track Story Pitches from their Authors, who are each given 100 points to spend on publishing their various stories. The resulting application allows Authors to login, submit stories for review, and
> check the status of their stories' progress. It also allows management to approve or deny any pitches.

### Package Structure

**Models:** Java Beans that represent tables in the Oracle SQL Database  
**Repositories:** Data Access Objects used to query the Database  
**Services:** Any necessary business logic - in this application, the Service Layer simply calls the Repository Layer  
**Controllers:** Application logic for handling HttpRequests and formatting HttpResponses  
**Servlets:** HttpServlet to listen for incoming requests and send corresponding responses  
**Utilities:** JDBC Connection Class to configure credentials and make connections to the AWS RDS instance

### Features

- Session Tracking
  - HttpSession objects used to store and access session information (such as current logged in user and the professional development resource in question)
- AJAX Calls
  - JavaScript is implemented for frent end design in order to send and receive asynchronous HTTP Requests and Responses
- HTML Design
  - CSS
  - JavaScript used for DOM Manipulation

### Testing

**JUnit**  
Some test cases implemented to ensure proper database connection and retrieval of information.

### Further Development

Some appropriate imrpovements would be to implement a messaging service tied to employees, and authors.  
Implementation of file uploading is not functional yet.  
Archiving of closed publications, while a table exists in the database, is not yet implemented.

### Required Dependencies

##### The below dependencies are required in the pom.xml file in order to ensure proper execution.

- Testing
  - JUnit v.4
- Database Access
  - Java Servlet
  - Oracle JDBC Driver
- Other
  - Google Gson (for formatting/sending/receiving HttpRequest and HttpResponses

```<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>4.0.1</version>
			<scope>provided</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.7</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
	<dependency>
	    <groupId>org.postgresql</groupId>
	    <artifactId>postgresql</artifactId>
	    <version>42.2.20</version>
	</dependency>

	<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.5.2.Final</version>
		</dependency>
	</dependencies>
```
