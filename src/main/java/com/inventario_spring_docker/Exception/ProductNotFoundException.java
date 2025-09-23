package com.inventario_spring_docker.Exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);  // Pasamos el mensaje al constructor padre
    }

}
