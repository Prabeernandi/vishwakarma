package com.burwasolution.vishwakarma.controller.exceptionHandler;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@Slf4j
@ControllerAdvice
public class ExceptionHandleController implements ErrorController {

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity<Error> handleNullPointerError(NullPointerException error) {
        log.error(error.getMessage());
        Result result = new Result();
        result.setResult(error.getLocalizedMessage());
        List<Result> setResult = new ArrayList<>();
        setResult.add(result);
        Error errorMsg = new Error(HttpStatus.NOT_FOUND, error.getLocalizedMessage(), setResult);
        return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<?> handleMethodError(org.springframework.web.HttpRequestMethodNotSupportedException error) {
        log.error(error.getMessage());
        Map<String, Object> getStateList = new HashMap<>();
        getStateList.put("status", HttpStatus.METHOD_NOT_ALLOWED);
        getStateList.put("result", null);
        getStateList.put("message", "Please Check The Input Method");
        return new ResponseEntity<>(getStateList, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<Error> handleElementError(NoSuchElementException error) {
        log.error(error.getMessage());
        Result result = new Result();
        result.setResult(error.getLocalizedMessage());
        List<Result> setResult = new ArrayList<>();
        setResult.add(result);
        Error errorMsg = new Error(HttpStatus.NOT_FOUND, error.getLocalizedMessage(), setResult);
        return new ResponseEntity<>(errorMsg, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<?> handleMissingInput(HttpMessageNotReadableException error) {
        log.error(error.getMessage());
        Result result = new Result();
        result.setResult("Required Request Body is Missing");
        List<Result> setResult = new ArrayList<>();
        setResult.add(result);
        Error errorMsg = new Error(HttpStatus.BAD_GATEWAY, "Required Request Body is Missing", setResult);
        return new ResponseEntity<>(errorMsg, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ExceptionResponse> handleUnauthorizedException(AuthenticationException error) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("UNAUTHORIZED");
        response.setErrorMessage(error.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> handleResourceExistsException(ResourceAlreadyExists error) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage("Username " + error.getMessage() + " Already Exists.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ExceptionResponse> usernameNotFoundException(UsernameNotFoundException error) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("NOT_FOUND");
        response.setErrorMessage("Username " + error.getMessage() + " Not Found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ExceptionResponse> expiredJwtTokenException(ExpiredJwtException error) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("BAD_GATEWAY");
        response.setErrorMessage(error.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
    }

//    public ResponseEntity<?> CustomExceptionHandlers(String message) {
//        Map<String, Object> noSuchElement = new HashMap<>();
//        noSuchElement.put("status", HttpStatus.NO_CONTENT);
//        noSuchElement.put("result", "message");
//        noSuchElement.put("message", "message");
//        return new ResponseEntity<>(noSuchElement, HttpStatus.NO_CONTENT);
//
//    }
}
