FROM openjdk:17-jdk-alpine as build-registry

COPY . /code
WORKDIR /code
RUN ./mvnw package


FROM openjdk:17-jdk-alpine as deploy-registry
RUN mkdir -p /opt/app
COPY --from=build-registry /code/target/*.jar /opt/app/
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/opt/app/ms-registry-server-0.0.1-SNAPSHOT.jar"]

