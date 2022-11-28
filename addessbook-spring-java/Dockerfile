#Start with a base image containing Java runtime
FROM openjdk:17-slim as build

#Information around who maintains the image
MAINTAINER at.schuele

# Add the application's jar to the container
COPY build/libs/addessbook-spring-java-0.0.1-SNAPSHOT.jar addressbook.jar

#execute the application
ENTRYPOINT ["java","-jar","/addressbook.jar"]