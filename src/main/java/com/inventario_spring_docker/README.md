## ENDPOINTS DISPONIBLES:

### Método	Endpoint	Descripción
```bash
GET	/api/products	Todos los productos
GET	/api/products/1	Producto con ID 1
GET	/api/products/search?name=posta	Búsqueda simple
GET	/api/products/search/advanced?name=posta&minPrice=2000	Búsqueda avanzada
POST	/api/products	Crear producto
PUT	/api/products/1	Actualizar producto
DELETE	/api/products/1	Eliminar producto
```

##confiracion de .properties
```bash
# Configuración de la base de datos MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_docker
spring.datasource.username=root
spring.datasource.password=

# Driver de MySQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


#levantar mysql y spring desde DOCKER
```bash
# 1. Limpiar
docker stop spring-app mysql-db
docker rm spring-app mysql-db

# 2. Crear MySQL con inventory_docker
docker run -d --name mysql-db --network spring-network -e MYSQL_ROOT_PASSWORD=root2 -e MYSQL_DATABASE=inventory_docker mysql:latest

# 3. Esperar
Start-Sleep -Seconds 30

# 4. Ejecutar Spring Boot
docker run -d -p 8080:8080 --name spring-app --network spring-network -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql-db:3306/inventory_docker -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=root2 inventoy-spring-app

# 5. Verificar
docker logs spring-app

```

#conectarse a la bd desde CMD
```bash
docker exec -it mysql-db mysql -u root -p
# Contraseña: root2

SHOW DATABASES;
USE inventory_docker;
SHOW TABLES;
SELECT * FROM products;
```

#VOULUIMEN POARA QUE NO SE ELIMINEN LOS DATOS
##paramos los contenedores, eliminamos y creamos de nuevo
```declarative
docker stop spring-app mysql-db
docker rm spring-app mysql-db

#2 volumen para MySQL
docker volume create mysql_data

# 3 MySQL con volumen
docker run -d --name mysql-db --network spring-network `
  -e MYSQL_ROOT_PASSWORD=root2 `
  -e MYSQL_DATABASE=inventory_docker `
  -v mysql_data:/var/lib/mysql `
  mysql:latest

# 4. Esperar que cargue MYSQL
Start-Sleep -Seconds 30

# 5. Ejecutar Spring Boot
docker run -d -p 8080:8080 --name spring-app --network spring-network `
  -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql-db:3306/inventory_docker `
  -e SPRING_DATASOURCE_USERNAME=root `
  -e SPRING_DATASOURCE_PASSWORD=root2 `
  inventoy-spring-app
```