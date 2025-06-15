# Contains the backend source files for the Pizza Restaurant App

## The app uses the following components

- Spring Boot Starter Web<br>
A Java Library that makes it easy to spin up a web service and Rest APIs<br>
https://www.geeksforgeeks.org/java/spring-boot-starter-web/

- Spring Boot - Spring Data JPA<br>A Java Library that makes it easy to interface with databases<br>
https://www.geeksforgeeks.org/java/spring-boot-spring-data-jpa/

- H2 Database embedded<br>A simple SQL based database for easy development.  Transitioning to MySQL or MSSQL is easy for the production rollout<br>
https://www.baeldung.com/spring-boot-h2-database

## Development

- This code uses Apache Maven for easier compilation and dependency management<br>https://maven.apache.org/


## Folder Structure
```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───cs492
│   │   │           └───backend
│   │   │               ├───controllers  <-- API definitions
│   │   │               ├───entities     <-- Datatypes for menus and orders
│   │   │               └───repositories <-- for Database access
│   │   └───resources
              └───application.properties (file) <- configuration
```





