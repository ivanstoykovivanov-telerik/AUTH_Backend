package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.exeptions;

public class TagNotFoundExeption extends RuntimeException {
    public TagNotFoundExeption(String message) {
        super(message);
    }
}
