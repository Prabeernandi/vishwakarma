package com.burwasolution.vishwakarma.controller.exceptionHandler;

public class ResourceAlreadyExists extends RuntimeException {

    public ResourceAlreadyExists(String message) {
        super(message);
    }
}
