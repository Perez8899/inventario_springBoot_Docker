package com.inventario_spring_docker.repository;

import com.inventario_spring_docker.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  //CRUD
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
