
## 📦 Sistema de Inventario - Spring Boot + React + Docker

📋 Descripción
Sistema de gestión de inventario desarrollado con Spring Boot (backend) y React (frontend). Permite administrar productos con operaciones CRUD completas, 
búsquedas simples y avanzadas. El proyecto está completamente contenerizado con Docker Compose para un despliegue rápido y portable.

## 🔗 Frontend: Repositorio React

## 🚀 Tecnologías Utilizadas
Categoría	Tecnologías
Backend	Java 17, Spring Boot 3.5.6, Spring Data JPA, Spring Validation
Frontend	React, Next.js
Base de Datos	MySQL 8
Contenedores	Docker, Docker Compose
Herramientas	Maven, Lombok, Postman

## ⚙️ Configuración de Base de Datos
application.properties
# Configuración de la base de datos MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_docker
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

## 🐳 Ejecución con Docker Compose (Recomendado)
Requisitos Previos

```bash
Docker y Docker Compose instalados

1. Clonar los repositorios
bash
 Clonar backend
git clone https://github.com/Perez8899/inventario_springBoot_Docker.git
cd inventario_springBoot_Docker

 Clonar frontend (en la misma carpeta padre o ajustar ruta en docker-compose)
git clone https://github.com/Perez8899/inventario-frontend.git ../inventario-frontend
2. Levantar todos los servicios
bash
docker-compose up -d
Este comando levantará:

MySQL en el puerto 3306

Spring Boot en el puerto 8080

React Frontend en el puerto 3000

3. Verificar que los contenedores están corriendo
bash
docker ps
4. Acceder a la aplicación
Frontend: http://localhost:3000

Backend API: http://localhost:8080

5. Detener los servicios
bash
docker-compose down
```

## 👨‍💻 Autor
```bash
Héctor José Pérez

GitHub: @Perez8899

Email: hectorjp43@gmail.com
```
