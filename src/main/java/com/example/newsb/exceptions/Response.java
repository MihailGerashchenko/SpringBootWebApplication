package com.example.newsb.exceptions;

public class Response {

    private String message;
    private String debugMessage;

    public Response(String message) {
    }

    public Response(String message, String debugMessage) {
        this.message = message;
        this.debugMessage = debugMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
