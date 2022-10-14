package com.springboot.childRESTFulAPI.exception;

import org.springframework.http.HttpStatus;

public class ChildAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public ChildAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ChildAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
