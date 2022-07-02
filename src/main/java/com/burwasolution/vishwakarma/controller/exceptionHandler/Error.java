package com.burwasolution.vishwakarma.controller.exceptionHandler;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Error {
    private final String status;
    private final String message;
    private final Result result;
}
