FROM openjdk:14
COPY ./build/libs/demo-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=gcp", "-jar", "demo-0.0.1-SNAPSHOT.jar"]