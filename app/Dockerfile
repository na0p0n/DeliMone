# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper files to the container
COPY gradlew .
COPY gradle ./gradle

# Copy the build configuration files
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY core ./core
COPY unit1-service-configuration ./unit1-service-configuration

# Make the Gradle wrapper executable
RUN chmod +x ./gradlew

# Build the application
# The --no-daemon option is used to ensure Gradle doesn't leave a daemon running in the container
RUN ./gradlew :unit1-service-configuration:build --no-daemon

# Get the JAR file from the build output
ARG JAR_FILE=unit1-service-configuration/build/libs/*.jar

# Copy the JAR file to the root of the app directory
COPY ${JAR_FILE} app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java","-jar","app.jar"]
