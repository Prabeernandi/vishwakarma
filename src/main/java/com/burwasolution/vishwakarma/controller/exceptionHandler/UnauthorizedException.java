package com.burwasolution.vishwakarma.controller.exceptionHandler;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String messages) {
        super(messages);
    }
}
