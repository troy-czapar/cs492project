# Contains the frontend source files for the Pizza Restaurant App

## The app uses the following components

- Spring Boot Starter Web<br>
A Java Library that makes it easy to spin up web services<br>
https://www.geeksforgeeks.org/java/spring-boot-starter-web/

- Spring Boot Thymeleaf
A Java Library that makes it easy to create dynamic web sites using HTML/Javascript and variables
https://www.geeksforgeeks.org/java/spring-boot-thymeleaf-with-example/

- Spring Security
A Java Library that makes it easy to secure web services<br>
https://github.com/Azure-Samples/azure-spring-boot-samples/tree/main/aad/spring-cloud-azure-starter-active-directory-b2c/aad-b2c-web-application
https://learn.microsoft.com/en-us/azure/developer/java/identity/enable-spring-boot-webapp-authentication-azure-ad-b2c?tabs=local
## Development
- This code uses Apache Maven for easier compilation and dependency management<br>https://maven.apache.org/

## Folder Structure
```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───cs492
│   │   │           └───frontend
│   │   │               ├───apiclient
│   │   │               │   └───datatypes   <-- Menu and Orders data types
│   │   │               └───controllers     <-- Defines the web server
│   │   └───resources
              └───application.properties (file) <- configuration
│   │       └───templates          <-- Location of HTML/Javascrip/image 
```







