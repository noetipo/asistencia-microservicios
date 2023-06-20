FROM openjdk:17-jdk-alpine as build-evento
COPY . /code
WORKDIR /code
RUN ./mvnw package  -DskipTests

FROM openjdk:17-jdk-alpine as deploy-evento
RUN mkdir -p /opt/app
COPY --from=build-evento /code/target/*.jar /opt/app/
ENTRYPOINT ["java", "-jar", "/opt/app/ms-evento-0.0.1-SNAPSHOT.jar"]

