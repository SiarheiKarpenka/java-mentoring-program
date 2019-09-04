# TDD, BDD, ATDD Module Practical Task Solution

Task description : Practical task - Practical task - TDD, BDD, ATDD.docx

## Prerequisites
| Artifact  | Version  | Comment  |
|---|---|---|
| Apache Maven  | 3.6.+ | [Apache Maven Download](https://maven.apache.org/download.cgi) |
| Java | 8.0.x | [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) |

## Install
Execute following command-line:
```
  cd <event-service>
  mvn clean install
```

## Usage
Execute following command-line:
```
java -jar event-service-rest\target\event-service-rest-3.0.0-SNAPSHOT.jar
```

## Debug (port 8000)
```
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar event-service-rest\target\event-service-rest-3.0.0-SNAPSHOT.jar
```

## Swagger access
Navigate:
```
http://localhost:8080/swagger-ui.html
```

## References
- [JUnit 5](https://www.baeldung.com/junit-5)
- [JUnit docs](https://junit.org/junit5/)
- [Cucumber docs](https://docs.cucumber.io/)
- [JBehave docs](https://jbehave.org/reference/latest/javadoc.html)
- [Testing In Spring Boot](https://www.baeldung.com/spring-boot-testing)
- [REST API Testing with Cucumber](https://www.baeldung.com/cucumber-rest-api-testing)
- [Dependency Injection](https://springframework.guru/dependency-injection-example-using-spring/)
- [Spring Testing](https://docs.spring.io/spring/docs/current/spring-framework-reference/testing.html)
- [Cucumber Transformer docs](https://static.javadoc.io/info.cukes/cucumber-core/1.2.5/cucumber/api/Transformer.html)
