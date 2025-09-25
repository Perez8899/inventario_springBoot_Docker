package com.inventario_spring_docker.response;

import com.inventario_spring_docker.models.Product;

public class ProductResponse extends ApiResponse<Product> {
    public ProductResponse(boolean success, String message, Product data) {
        super(success, message, data);
    }

    // Métodos estáticos para facilitar la creación
    public static ProductResponse success(String message, Product product) {
        return new ProductResponse(true, message, product);
    }

    public static ProductResponse error(String message, Product updatedProduct) {
        return new ProductResponse(false, message, null);
    }
}