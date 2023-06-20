FROM openjdk:17-jdk-alpine as build-asistencia
COPY . /code
WORKDIR /code
RUN ./mvnw package  -DskipTests

FROM openjdk:17-jdk-alpine as deploy-asistencia
RUN mkdir -p /opt/app
COPY --from=build-asistencia /code/target/*.jar /opt/app/
ENTRYPOINT ["java", "-jar", "/opt/app/ms-asistencia-0.0.1-SNAPSHOT.jar"]

