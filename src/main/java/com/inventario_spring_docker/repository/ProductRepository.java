package com.inventario_spring_docker.repository;

import com.inventario_spring_docker.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //CRUD
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE  %:name%")
    List<Product> finByName(@Param("name") String name);

    // Sin @Query (Spring Data JPA lo genera automáticamente)
    List<Product> findByNameContainingIgnoreCase(String name);
}
