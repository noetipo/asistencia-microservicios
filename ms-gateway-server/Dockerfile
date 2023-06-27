FROM openjdk:17-jdk-alpine as build-gateway
COPY . /code
WORKDIR /code
RUN ./mvnw package


FROM openjdk:17-jdk-alpine as deploy-gateway
RUN mkdir -p /opt/app
COPY --from=build-gateway /code/target/*.jar /opt/app/
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/opt/app/ms-gateway-server-0.0.1-SNAPSHOT.jar"]

