# Java 8 and 9, 10, 11+ Module Practical Task

##### 1.	Download Java SE Development Kit 11 according to your OS and processor’s architecture.
##### 2.	Install Java Development Kit according to JDK installation instructions (see also PATH and CLASSPATH).
##### 3.	Download Apache Maven 3.6.0 according to your OS and processor’s architecture.
##### 4.	Install Apache Maven according to installation instructions.
##### 5.	Create maven project with 4 modules (see Java 9 modules) :
	*	event-service-api
	*	event-service-client
	*	event-service-workshop-impl
	*	event-service-techtalk-impl
##### 6.	event-service-api module should contain EventService interface with getEvents() method.
##### 7.	Create module-info.java which 
	*	requires package with EventService.
##### 8.	event-service-workshop-impl module should contain TechTalkEventService which implements EventService interface and responds with list of tech-talk topics.
##### 9.	Create module-info.java which 
	*	requires package with EventService;
	*	exports package with TechTalkEventService;
	*	provides EventService with TechTalkEventService implementation.
Note: 
	*	use Stream.of() for creation of stream of available topics;
	*	use Stream.map() for update of each value with specific prefix;
	*	implement static prefix method which concatenates pre-define prefix to input string;
	*	use Stream.collect() in order to convert Stream to unmodifiable List<String> (Collectors.toUnmodifiableList()).
##### 10.	event-service-techtalk-impl module should contain WorkshopEventService which implements EventService interface and responds with list of tech-talk topics.
##### 11.	Create module-info.java which 
	*	requires package with EventService;
	*	exports package with WorkshopEventService;
	*	provides EventService with WorkshopEventService implementation.
    Note: 
	*	use Stream.of() for creation of stream of available topics;
	*	use Stream.map() for update of each value with specific prefix;
	*	implement static prefix method which concatenates pre-define prefix to input string;
	*	use Stream.collect() in order to convert Stream to unmodifiable List<String>.
(Collectors.toUnmodifiableList()).
 
##### 12.	event-service-client should contain EventServiceClient with main method which:
	*	Loads available EventService implementation using java.util.ServiceLoader;
	*	Retrieves available events for EventService implementations;
	*	Prints events to console using MarkdownService formatList() method.
##### 13.	MarkdownService class should contain formatList method which accepts List<String>.
    Note:
	*	invoke stream() method in order to create stream from collection;
	*	use map() method in order to append ‘*’ to String using lambda;
	*	use collect() and Collectors.joining method in order to append ‘\n’ to String.
##### 14.	Create module-info.java which 
	*	requires package with EventService;
	*	uses EventService .
##### 15.	Use var for definition of local variables wherever it’s applicable.
##### 16.	Feel free to modify implementation by introducing new features and capabilities of Java 8 – 11.

##### Note:
	*	Run application:
	```
	    java --module-path <path-to-event-service-api-jar>;<path-to-event-service-client-jar>;<path-to-event-service-workshop-impl-jar>;<path-to-event-service-techtalk-impl-jar>; -m <event-service-client-module-name>/<package.Main>
	```
	*	Make sure that JAR contains necessary modules using java –p <jar-path> --list-modules.


## References

[Oracle Java SE Development Kit 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

[Oracle Java Install Instructions](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)

[Java PATH and CLASSPATH](https://docs.oracle.com/javase/tutorial/essential/environment/paths.html)

[Apache Maven](https://maven.apache.org/download.cgi)

[Apache Maven Install Instructions](https://maven.apache.org/install.html)

[Apache Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/)

[Apache Maven Jar Plugin](https://maven.apache.org/plugins/maven-jar-plugin/)

[Oracle Java 8 new features](https://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html)

[Oracle Java 9 new features](https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-C23AFD78-C777-460B-8ACE-58BE5EA681F6)

[Oracle Java 10 new features](https://www.oracle.com/technetwork/java/javase/10-relnote-issues-4108729.html#NewFeature)

[Oracle Java 11 new features](https://www.oracle.com/technetwork/java/javase/11-relnote-issues-5012449.html#NewFeature)