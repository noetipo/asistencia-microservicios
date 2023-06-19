FROM openjdk:17-jdk-alpine as build-auth

RUN mkdir -p /code
COPY . /code
WORKDIR /code
# RUN ./mvnw compile
RUN ./mvnw package  -DskipTests


FROM openjdk:17-jdk-alpine as deploy-auth

RUN mkdir -p /opt/app

COPY --from=build-auth /code/target/*.jar /opt/app/
#EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/opt/app/auth-service-0.0.1-SNAPSHOT.jar"]

