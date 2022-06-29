package com.burwasolution.vishwakarma.controller.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private String errorMessage;
    private String requestedURI;
    private String errorCode;


    public void callerURL(final String requestedURI) {
        this.requestedURI = requestedURI;
    }
}
