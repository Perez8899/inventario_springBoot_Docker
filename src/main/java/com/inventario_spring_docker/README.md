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

#Para produccion
#spring.jpa.hibernate.ddl-auto=validate
#spring.jpa.show-sql=false


# Otras configuraciones útiles
#Sincroniza la zona horaria entre tu aplicación Java y la base de datos MySQL.
spring.jpa.properties.hibernate.jdbc.time_zone=UTC 

#Controla la duración de la sesión de Hibernate. ---e cierra al terminar la transacción del servicio
spring.jpa.open-in-view=false
```