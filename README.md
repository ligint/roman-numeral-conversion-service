# roman-numeral-conversion-service


Java web service to convert integers to roman numeral strings

Input must be any integer value in the range 1-3999.

Prerequisites:
* Docker
* Docker Compose

Getting Started:

1. Clone the repository
2. Start your docker service
3. cd roman-numeral-conversion-service
4. Build the application:
   Command : docker-compose build
5. Start the application
   docker-compose up -d
6. Access the API:
The API is now running and can be accessed at http://localhost:8080/romannumeral


API Info:

* Request: GET http://localhost:8080/romannumeral?query=10

Response: { numeral: 10, romanNumeral: "X" }

* Request: GET http://localhost:8080/romannumera?query=-10

Response: 400 BAD_REQUEST

* Request: GET http://localhost:8080/romannumera?query=3999

Response: 400 BAD_REQUEST

Also available are the following spring boot actuator endpoints:

/actuator
/actuator/health
/actuator/info
/actuator/metrics
/actuator/httptrace


Technologies Used
Java
Spring Boot
Maven
JUnit 5
Docker
Docker Compose