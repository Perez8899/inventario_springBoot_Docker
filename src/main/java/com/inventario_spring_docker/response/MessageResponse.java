package com.inventario_spring_docker.response;

public class MessageResponse extends ApiResponse<Void> {
    public MessageResponse(boolean success, String message) {
        super(success, message, null);
    }

    public static MessageResponse success(String message) {
        return new MessageResponse(true, message);
    }

    public static MessageResponse error(String message) {
        return new MessageResponse(false, message);
    }
}
