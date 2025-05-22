# Etapa de build com Gradle e JDK 17
FROM gradle:8.7-jdk17-alpine AS builder
WORKDIR /app

COPY . .

RUN chmod +x ./gradlew

RUN ./gradlew build -x test --no-daemon

# Etapa de execução com a mesma imagem
FROM gradle:8.7-jdk17-alpine
WORKDIR /app

# Cria um usuário sem privilégios
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
