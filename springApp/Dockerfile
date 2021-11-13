FROM maven:3-jdk-8-slim as build
COPY pom.xml .
COPY src src

RUN mvn package

FROM openjdk:8-jdk-alpine
COPY --from=build target/*.jar app.jar
CMD [ "sh", "-c", "java $JAVA_OPTS -Dserver.port=$PORT -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]