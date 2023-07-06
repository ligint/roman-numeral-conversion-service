# Use a base image with Java and Maven pre-installed
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and project files
COPY pom.xml .
COPY src ./src

# Build the application using Maven
RUN mvn package -DskipTests

# Use a lightweight base image with Java only
FROM openjdk:19-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "app.jar"]
