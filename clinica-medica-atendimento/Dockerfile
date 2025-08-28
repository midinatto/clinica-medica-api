
FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/clinica-medica-atendimento-1.0-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]