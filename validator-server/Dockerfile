FROM openjdk:17-jdk-slim
COPY target/validator-server-0.0.1-SNAPSHOT.war validator_server.war
EXPOSE 8081
CMD ["java", "-jar", "validator_server.war"]
