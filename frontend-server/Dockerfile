FROM openjdk:17-jdk-slim
COPY target/frontend-server-0.0.1-SNAPSHOT.war frontend_server.war
EXPOSE 8082
CMD ["java", "-jar", "frontend_server.war"]