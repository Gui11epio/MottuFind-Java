# Etapa de build com Gradle 8.7 e JDK 18 (condizente com build.gradle)
FROM gradle:8.7-jdk21-alpine AS builder
WORKDIR /app

# Copia o projeto
COPY . .

# Usa o wrapper para compilar com a versão correta do Gradle configurado
RUN ./gradlew build

# Etapa de execução com JDK 18 leve
FROM gradle:8.7-jdk21-alpine
WORKDIR /app

# Copia o .jar compilado
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
