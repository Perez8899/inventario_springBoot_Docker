# Build stage (compilar en Docker)
FROM maven:3.9.3-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiar solo pom y src
COPY pom.xml .
COPY src ./src

# Construir la app sin tests
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar el JAR desde el builder
COPY --from=builder /app/target/inventario_spring_docker-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
