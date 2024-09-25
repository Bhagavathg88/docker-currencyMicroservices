FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/build/libs/*-bootjar.jar
COPY /build/libs/*-bootjar.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]