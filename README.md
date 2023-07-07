# roman-numeral-conversion-service


Java web service to convert integers to roman numeral strings

Input must be any integer value in the range 1-3999.

**Prerequisites:**
* Docker
* Docker Compose

**Getting Started:**

1. Clone the repository
2. Start your docker service
3. Change the directory 

   ``` cd roman-numeral-conversion-service ```

4. Build the application:

   ``` Command : docker-compose build ```

5. Start the application

   ``` docker-compose up -d ```

6. Access the API: http://localhost:8080/romannumeral


**API Info:**

* Request: GET http://localhost:8080/romannumeral?query=10

   ``` Response: {"input":"10","romanNumeral":"X"} ```

* Request: GET http://localhost:8080/romannumera?query=-10

   ``` Response: 400 BAD_REQUEST ```

* Request: GET http://localhost:8080/romannumera?query=3999

  ``` Response: 400 BAD_REQUEST ```

**Spring boot actuator endpoints(Eg: Metrics, Monitoring, Logging etc.)** :

* Request: GET http://localhost:8080/actuator

   ``` Response: Information regarding all the actuators. ```

* Request: GET http://localhost:8080/actuator/info

   ``` Response: Custom Application Information like version numbers or environment-specific details. ```

* Request: GET http://localhost:8080/actuator/metrics

   ``` Response: Information regarding application metrics like request counts, response times, memory usage etc. ```

* Request: GET http://localhost:8080/actuator/health

   ``` Response: Information regarding health of the application.```

* Request: GET http://localhost:8080/actuator/loggers

   ``` Response: It enables you to dynamically manage logging configurations without restarting the application. ```


**Project Structure**
```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── example/
│   │   │   │       └── romannumeralconversionservice/
│   │   │   │           ├── controller/
│   │   │   │           ├── model/
│   │   │   │           └── RomanNumeralConversionServiceApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   ├── test/
│   │   └── java/
│   │       ├── com/
│   │       │   └── example/
│   │       │       └── romannumeralconversionservice/
│   │       │           ├── RomanNumeralIntegrationTests/
│   │       │           ├── RomanNumeralModelConversionServiceApplicationTests/
│   │       │           └── RomanNumeralUnitTests/
│   
│── docker-compose.yml
│── Dockerfile
├── pom.xml
└── README.md
```


* src/main/java: Contains the main Java source code for your project.

* com.example.romannumeralconversionservice.controller: Rest API Controller for the service
* com.example.romannumeralconversionservice.model: Model Class containing Map for roman conversion
* com.example.romannumeralconversionservice.Application: Main entry point of the Spring Boot application.
* src/main/resources: Contains application properties, static files, and templates.

* application.properties: Configuration properties for the application.

* src/test/java: Contains test cases for your project.
* com.example.romannumeralconversionservice.RomanNumeralUnitTests: Unit Tests for the service
* com.example.romannumeralconversionservice.RomanNumeralIntegrationTests: Integration Tests for the service

* docker-compose.yml: Contains the configuration for docker container
* Dockerfile: Contains set of instructions that define the environment and steps needed to build and configure the container image


**Technologies Used**
* Java
* Spring Boot
* Maven
* JUnit 5
* Docker
* Docker Compose

**Dependencies**
* Spring Boot
* Spring Web
* Spring Boot Actuators
* JUnit 5


**Error and Exception Handling**
1. ErrorController Spring Boot Interface
2. ResponseEntity class provided by Spring Framework for Error and Exception Handling