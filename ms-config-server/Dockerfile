FROM openjdk:17-jdk-alpine as build

COPY . /code
WORKDIR /code
RUN ./mvnw package


FROM openjdk:17-jdk-alpine as deploy
RUN mkdir -p /opt/app
COPY --from=build /code/target/*.jar /opt/app/
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/opt/app/ms-config-server-0.0.1-SNAPSHOT.jar"]

