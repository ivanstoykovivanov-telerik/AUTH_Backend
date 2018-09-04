package com.nouhoun.springboot.jwt.integration.extensionrepository.exceptions;

public class InvalidArgumentExeption extends RuntimeException {
    public InvalidArgumentExeption(String message) {
        super(message);
    }

    public InvalidArgumentExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
