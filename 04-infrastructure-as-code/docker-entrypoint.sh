#!/bin/bash
echo "Start application"

echo $JAVA_OPTS

java -jar event-service-rest-1.0.0-SNAPSHOT.jar

/bin/bash
tail -f /dev/null