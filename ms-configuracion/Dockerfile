FROM openjdk:17-jdk-alpine as build-configuration
COPY . /code
WORKDIR /code
RUN ./mvnw package  -DskipTests

FROM openjdk:17-jdk-alpine as deploy-configuration
RUN mkdir -p /opt/app
COPY --from=build-configuration /code/target/*.jar /opt/app/
ENTRYPOINT ["java", "-jar", "/opt/app/ms-configuracion-0.0.1-SNAPSHOT.jar"]

