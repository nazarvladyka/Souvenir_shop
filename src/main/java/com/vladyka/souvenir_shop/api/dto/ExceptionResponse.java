package com.vladyka.souvenir_shop.api.dto;

public class ExceptionResponse {
    private String status;
    private String message;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}