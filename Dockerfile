# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine as build

WORKDIR /app

COPY build/libs/MVCInterfaceHttp-1.0-plain.jar MVCInterfaceHttp-1.0-plain.jar
CMD ["java", "-jar", "app.jar"]
