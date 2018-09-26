FROM openjdk:8-jdk-alpine

LABEL maintainer=pawel.wojtowicz@trapezegroup.pl

VOLUME /tmp

ARG JAR_FILE=target/RuntimeUnitCatalog-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} runtimeCatalogue.jar

ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/runtimeCatalogue.jar"]
