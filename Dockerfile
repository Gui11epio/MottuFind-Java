
FROM gradle:8.7-jdk18 AS builder
WORKDIR /app
COPY . .

RUN gradle build -x test

FROM openjdk:18-jdk-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
