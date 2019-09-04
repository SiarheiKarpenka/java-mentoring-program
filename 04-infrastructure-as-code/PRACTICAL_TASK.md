# Infrastructure as a Code Practical Task 

##### 1. Install pre-requisites	
	*	Download and Install Java SE Development Kit 11.0.x according to your OS and processor’s architecture.
	*	Download and Install Apache Maven 3.6.x according to your OS and processor’s architecture.
	*	Download and Install Docker 1.18.x according to your OS and processor’s architecture.
	*	Download and Install Docker Compose 1.21.x according to your OS and processor’s architecture.
	*	Register account on Docker Hub.
	*	Login to Docker Registry.
	*   Validate Login
	docker login --username=siarheikarpenka

##### 2. Elaborate REST Web Service
	Create maven project with 3 modules:
	*	event-service-api
	*	event-service-impl
	*	event-service-rest
    
    event-service-api module should contain Event class with following fields:
	*	id;
	*	title;
	*	place;
	*	speaker;
	*	eventType;
	*	dateTime.
    
    event-service-api module should contain EventService interface with following methods:
	*	createEvent(…);
	*	updateEvent(…);
	*	getEvent(…);
	*	deleteEvent();
	*	getAllEvents().
    
    event-service-impl module should contain EventServiceImpl which implements EventService interface and responds with list of Events.
      Note: feel free to use any database (filesystem, any db, in memory storage)
    
    event-service-rest module should contain EventServiceController which provides REST API interface for manipulation of Events.
    
    Document methods in EventServiceController using Swagger 2 annotations.
    Implement Application class with @SpringBootApplication annotation and main method.
    Create runnable Spring Boot JAR with dependencies using spring-boot-maven-plugin.

##### 3.	Create Dockerfile in root folder of repo.
	*	extend event-service image from CentOS 7 image (see public Docker registry).
	*	add maintainer info.
	*	set user to root.
	*	add command to deploy JRE 11.
	*	create /apps/services directory.
	*	add target/event-service-*.jar via ADD to /apps/services.

##### 4.	Create docker-entrypoint.sh with command to start /apps/services/event-service.jar on 7080 port.

##### 5.	Create build.sh file with bash script command to build image with tag specifying version.

##### 6.	Create push.sh file with bash script command to push image to public Docker registry.

##### 7.	Create up.sh file with bash script command to start Docker container with following configuration:
	*	container should be ran in daemon mode;
	*	service should be exposed via 8081 port to host machine (note within container its available via 8080);

##### 8.	Execute build.sh and up.sh, validate service availability – execute sample requests.

##### 9.	Create docker-compose folder in root of git repo.

##### 10.	Create docker-compose file in docker-compose/event-service-docker-compose.yml.

##### 11.	Configure event-service-docker-compose.yml in order to include following configuration:
	*	docker-compose should include definition of subnet;
	*	docker-compose should include event-service image;
	*	event-service image should have memory limit 2Gb;
	*	image should have JAVA_OPTS environment variable with memory restrictions depending on event-service requirements;
	*	event-service image should be added to subnet.

##### 12.	Create up-docker-compose.sh file to start event-service-docker-compose.yml in deamon mode.

##### 13.	Execute up-docker-compose.sh, demonstrate service availability – execute sample requests.

##### 14.	Check following commands:
	*	docker images –a (lists all available images in local docker registry)
	*	docker ps –a (lists docker containers)
	*	docker logs $container-id (prints logs from container’s console)
	*	docker exec –it $container-id bash (enters container)

##### 15.	Create remove-docker-image.sh file with bash script command to remove all images from local docker registry).

##### 15.	Create kubernetes-compose.yml with deployment of 3 replicas of Event Service Container


## References
	*	[Docker Get Started](https://docs.docker.com/get-started/)
	*	[Docker CLI](https://docs.docker.com/engine/reference/commandline/cli/)
	*	[Docker Compose](https://docs.docker.com/compose/overview/)
	*	[Docker Hub](https://hub.docker.com/)
	*	[Docker Hub OpenJDK](https://hub.docker.com/_/openjdk/)
	*	[Spring Boot](https://spring.io/projects/spring-boot)
	*	[Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
	*	[Swagger](https://swagger.io/docs/)