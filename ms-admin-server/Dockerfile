FROM openjdk:17-jdk-alpine as build-admin
COPY . /code
WORKDIR /code
RUN ./mvnw package


FROM openjdk:17-jdk-alpine as deploy-admin

RUN mkdir -p /opt/app

COPY --from=build-admin /code/target/*.jar /opt/app/
EXPOSE 6060
ENTRYPOINT ["java", "-jar", "/opt/app/ms-admin-server-0.0.1-SNAPSHOT.jar"]

