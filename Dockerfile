FROM adoptopenjdk/openjdk12:latest
MAINTAINER arteemtkacheev@gmail.com
COPY service/build/libs/service-1.0.jar notification-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "notification-service.jar"]