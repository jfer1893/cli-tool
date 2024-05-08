# Use a base image with Java installed
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY cli-tool.jar /app

# Command to run when the container starts
CMD ["java", "-jar", "cli-tool.jar"]
