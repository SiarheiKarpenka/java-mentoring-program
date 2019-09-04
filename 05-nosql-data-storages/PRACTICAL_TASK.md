# NoSQL Data Storage Module Practical Task 

##### 1.	Download Java SE Development Kit 8 according to your OS and processor’s architecture.
##### 2.	Install Java Development Kit according to JDK installation instructions (see also PATH and CLASSPATH).
##### 3.	Download Apache Maven 3.6.0 according to your OS and processor’s architecture.
##### 4.	Install Apache Maven according to installation instructions.
##### 5.	Install MongoDB 4.0.x+ .
##### 6.	Install MongoDB Compass 1.16.x+.
##### 7.	Clone event-service git repo (or implement any REST service using Spring Boot from the scratch).
##### 8.	event-service-dto module should contain following classes:
    Address:
	*	String city;
	*	String street;
	*	String country;
	
    Speaker:
	*	BigInteger id;
	*	String firtName;
	*	String lastName;
	*	Email email;
	
	Email:
	*	String value;
	
    Event:
	*	BigInteger id;
	*	String title;
	*	Address address;
	*	Speaker speaker;
	*	EventType eventType;
	*	LocalDateTime dateTime.
##### 9.	event-service-api module should contain EventService interface with following methods:
	*	createEvent(…);
	*	updateEvent(…);
	*	getEvent(…);
	*	deleteEvent();
	*	getAllEvents();
	*	getAllEventsByTitle(…).
##### 10.	event-service-api module should contain SpeakerService interface with following methods:
    *	createSpeaker(…);
    *	updateSpeaker(…);
    *	getSpeaker(…);
    *	deleteSpeaker();
    *	getAllSpeakers().
##### 10.	event-service-impl module should contain EventServiceImpl which implements EventService interface.
    Note: use MongoDB as database
##### 11.	event-service-impl module should contain SpeakerServiceImpl which implements SpeakerService interface.
    Note: use MongoDB as database
##### 12.	event-service-rest module should contain EventServiceController which provides REST API interface according to 2nd or 3rd level of REST API maturity and responds with list of Events.
##### 13.	event-service-rest module should contain SpeakerServiceController which provides REST API interface according to 2nd or 3rd level of REST API maturity and responds with list of Speakers.
##### 14.   Demonstrate operations with Speaker adn Event via REST Client, show DB state using MondoDB Compass.

## References

[Install MongoDB](https://docs.mongodb.com/manual/installation/)

[MongoDB Compass](https://www.mongodb.com/products/compass)

[Spring Data MongoDB](http://spring.io/projects/spring-data-mongodb)

[Configuring Spring Boot for MongoDB](https://springframework.guru/configuring-spring-boot-for-mongo/)