package com.burwasolution.vishwakarma.controller.exceptionHandler;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Error {
    private final HttpStatus status;
    private final String message;
    private final List<Result> result;
}
