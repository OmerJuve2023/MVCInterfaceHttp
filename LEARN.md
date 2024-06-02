# MvcInterfaceHttpApplication Overview

MvcInterfaceHttpApplication is a Spring Boot application developed in Java. It uses a REST client to interact with a
remote API. The project uses Gradle as a build tool and follows a typical Spring Boot project structure.

## Key Classes

### Company

The `Company` class is a record in Java, which is a special kind of class used to model plain data aggregates with final
fields. It represents a company entity in the application with three fields: `name`, `catchPhrase`, and `bs`.

## Configuration

The application's configuration is managed through the `application.yml` file. This includes the application name,
server port, and logging configuration. The logging level for the application package is set to DEBUG.

## Containerization

The application supports containerization through Docker. The `Dockerfile` in the project root directory provides the
necessary commands to build a Docker image of the application. The Docker image is based on the `openjdk:17-jdk-alpine`
image and includes the application's JAR file.

## Authors

The application is developed by OmerJuve2023.

## License

The project is licensed under the MIT License.