FROM openjdk:17-jdk-alpine as build-bff-asistencia
COPY . /code
WORKDIR /code
RUN ./mvnw package  -DskipTests

FROM openjdk:17-jdk-alpine as deploy-bff-asistencia
RUN mkdir -p /opt/app
COPY --from=build-bff-asistencia /code/target/*.jar /opt/app/
ENTRYPOINT ["java", "-jar", "/opt/app/ms-bff-asistencia-web-0.0.1-SNAPSHOT.jar"]

