FROM maven:3.9.6-eclipse-temurin-21 AS build

LABEL authors="aleksi246"

WORKDIR /app

COPY pom.xml .
COPY . /app

RUN mvn -B clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/converter-1.0-SNAPSHOT.jar /app/converter.jar

ENTRYPOINT ["java","-cp","/app/converter.jar","com.example.TemperatureConverterApp"]