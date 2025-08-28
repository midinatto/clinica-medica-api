FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/clinica-medica-agendamento-1.0-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]