package com.inventario_spring_docker.repository;

import com.inventario_spring_docker.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //CRUD
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("SELECT c FROM Product c WHERE name LIKE  %:name%")
    List<Product> finByName(@Param("name") String name);
}
