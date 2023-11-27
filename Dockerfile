FROM openjdk:17-jdk-slim-buster

WORKDIR /app

COPY target/test-jar-jenkins-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "test-jar-jenkins-0.0.1-SNAPSHOT.jar"]