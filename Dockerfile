FROM maven:latest AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean install

FROM openjdk:21-slim

WORKDIR /app

COPY --from=build /app/target/loan-application.jar .

CMD ["java", "-jar", "loan-application.jar"]