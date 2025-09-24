package com.inventario_spring_docker.services;

import com.inventario_spring_docker.models.Product;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ProductService {     //public POR DEFECTO=

    ResponseEntity<List<Product>> getAllProductos();

    Product getProductId(Integer id);

    ResponseEntity<String> addProducto( Product product);

    ResponseEntity<Void> deleteProduct( Integer id);

    ResponseEntity<String> updateProduct(Integer id, Product upProduct);

    // 🔍 SEARCH MEJORADO
    ResponseEntity<List<Product>> searchProduct(String name);

    }