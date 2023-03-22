FROM openjdk:19-jdk
MAINTAINER JediSebas
COPY target/rest-api-0.0.1.jar rest-api-0.0.1.jar
ENTRYPOINT ["java","-jar","/rest-api-0.0.1.jar"]
EXPOSE 8080