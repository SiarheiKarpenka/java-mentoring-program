# Infrastructure as Code Practical Task Solution

### Prerequisites
| Artifact  | Version  | Location  |
|---|---|---|---|---|
| Maven | 3.6.x  | [Apache Maven](http://maven.apache.org/download.cgi)  |
| Java | 11.0.x | [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/index.html)  |
| Docker CE  | 1.18.x  | [Docker CE](https://docs.docker.com/install/)  |
| Docker Compose  | 1.21.x  | [Docker Compose](https://docs.docker.com/compose/install)  |

### Build Docker Image
```cmd
  docker build -t siarheikarpenka/event-service:1.0.0-SNAPSHOT .
```

### Push Docker Image  
```cmd
  docker push siarheikarpenka/event-service:1.0.0-SNAPSHOT
``` 

### Up Docker Image  
```cmd
  docker run --name event-service -p 8080:8080 siarheikarpenka/event-service:1.0.0-SNAPSHOT -d
``` 

### Stop Docker Container  
```cmd
  docker ps –a (lists docker containers)
  docker stop $docker-container-id
``` 

### Up Docker Compose  
```cmd
   docker-compose -f docker-compose.yml up -d
``` 

### Stop Docker Compose  
```cmd
   docker-compose -f docker-compose.yml down
``` 

### Start Kubernetes Compose  
```cmd
   docker stack deploy --compose-file kubernetes-compose.yml event-service-stack
``` 

### Explore Kubernetes Services
```cmd
   docker stack services event-service-stack
``` 


## Docker container to host machine port mapping
| Service name  | Port on host machine |
|------------------|------|
| Event Service | 8080 |

## Swagger access
Navigate:
```
http://localhost:8080/swagger-ui.html
```
Note: clean cache and cookies in case if some issues related to access

## References
	*	[Docker Get Started](https://docs.docker.com/get-started/)
	*	[Docker CLI](https://docs.docker.com/engine/reference/commandline/cli/)
	*	[Docker Compose](https://docs.docker.com/compose/overview/)
	*	[Docker Hub](https://hub.docker.com/)
	*	[Docker Hub OpenJDK](https://hub.docker.com/_/openjdk/)
	*	[Spring Boot](https://spring.io/projects/spring-boot)
	*	[Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
	*	[Swagger](https://swagger.io/docs/)