# Java 8 and 9, 10, 11+ Module Practical Task Solution

Task description : Practical task - Java 8 and 9, 10, 11+.docx
Read more in our blog post: [Getting Started with Java 9 Modules]

## Prerequisites
| Artifact  | Version  | Comment  |
|---|---|---|
| Java SE Development Kit  | 11.0.+  | [Java SE Development Kit 11 Downloads](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)  |
| Apache Maven  | 3.6.+ | [Apache Maven Download](https://maven.apache.org/download.cgi)

## Install
Execute following command-line:
```
  cd <event-service>
  mvn clean install
```

## Usage
Execute following command-line:
```
java --module-path event-service-api\target\event-service-api-1.0.0-SNAPSHOT.jar;event-service-client\target\event-service-client-1.0.0-SNAPSHOT.jar;event-service-workshop-impl\target\event-service-workshop-impl-1.0.0-SNAPSHOT.jar;event-service-techtalk-impl\target\event-service-techtalk-impl-1.0.0-SNAPSHOT.jar -m com.epam.jmp/com.epam.jmp.EventServiceClient
```

## References
- [Oracle Java 8 new features](https://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html)
- [Oracle Java 9 new features](https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-C23AFD78-C777-460B-8ACE-58BE5EA681F6)
- [Oracle Java 10 new features](https://www.oracle.com/technetwork/java/javase/10-relnote-issues-4108729.html#NewFeature)
- [Oracle Java 11 new features](https://www.oracle.com/technetwork/java/javase/11-relnote-issues-5012449.html#NewFeature)
- [Getting Started with Java 9 Modules](https://labs.consol.de/development/2017/02/13/getting-started-with-java9-modules.html)