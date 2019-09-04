# NoSQL Data Storage Practical Task Solution

Task description : Practical task - Infrastructure as Code.docx

### Prerequisites
| Artifact  | Version  | Location  |
|---|---|---|---|---|
| Java | 8.0.x | [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  |
| Docker CE  | 1.12.x  | [Docker CE](https://www.docker.com/community-edition)  |
| Maven | 3.6.x  | [Apache Maven](http://maven.apache.org/download.cgi)  |
| MongoDB | 4.0.x+  | [MongoDB](https://www.mongodb.com/download-center)  |
| MongoDB Compass | 1.16.x+  | [MongoDB Compass](https://www.mongodb.com/products/compass)  |

## Install
Execute following command-line:
```
  cd <event-service>
  mvn clean install
```

## Usage
Execute following command-line:
```
java -jar event-service-rest\target\event-service-rest-2.0.0-SNAPSHOT.jar
```

## Debug (port 8000)
```
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar event-service-rest\target\event-service-rest-2.0.0-SNAPSHOT.jar
```

## Swagger access
Navigate:
```
http://localhost:8080/swagger-ui.html
```

Note: clean cache and cookies in case if some issues related to access

## References

[Install MongoDB](https://docs.mongodb.com/manual/installation/)

[MongoDB Compass](https://www.mongodb.com/products/compass)

[Spring Data MongoDB](http://spring.io/projects/spring-data-mongodb)

[Configuring Spring Boot for MongoDB](https://springframework.guru/configuring-spring-boot-for-mongo/)
