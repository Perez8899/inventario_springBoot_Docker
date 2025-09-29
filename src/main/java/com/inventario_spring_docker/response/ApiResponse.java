package com.inventario_spring_docker.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data; //Generico puede ser de cualquier tipo

    // Constructores
//    public ApiResponse(boolean success, String message) {
//        this.success = success;
//        this.message = message;
//    }
}
