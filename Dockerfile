# Multi-stage build se crea primero el .jar saltando los TEST de PROPERTIEs
#FROM maven:3.8.6-openjdk-17 AS builder
#WORKDIR /app
#COPY . .
#RUN mvn clean package -DskipTests

# imagen base de Java
FROM openjdk:17-jdk-slim

#donde crear espacio de trabajo
WORKDIR /app

# Copiar el JAR de la aplicación (generado por Maven)
#COPY target/*.jar app.jar
COPY target/inventario_spring_docker-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que usa Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]