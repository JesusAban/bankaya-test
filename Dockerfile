FROM openjdk:17-jdk
LABEL authors="jesus"
ARG JAR_FILE=target/pokemon-test-1.0.0.jar
COPY ${JAR_FILE} pokemon-test.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pokemon-test.jar"]