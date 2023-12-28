FROM openjdk:17-jdk-slim
COPY target/crud-0.0.1-SNAPSHOT.war crud_server.war
EXPOSE 8080
CMD ["java", "-jar", "crud_server.war"]
