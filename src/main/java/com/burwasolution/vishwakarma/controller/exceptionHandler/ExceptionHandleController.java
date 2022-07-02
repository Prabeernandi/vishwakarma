package com.burwasolution.vishwakarma.controller.exceptionHandler;

import io.jsonwebtoken.ExpiredJwtException;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class ExceptionHandleController implements ErrorController {

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity<Error> handleNullPointerError(NullPointerException error) {
        log.error(error.getMessage());

        Error errorMsg = new Error("Error", error.getLocalizedMessage(), null);
        return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
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

        Error errorMsg = new Error("Error", error.getMessage(), null);
        return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<Error> handleNotFound(NotFoundException error) {
        log.error(error.getMessage());

        Error errorMsg = new Error("Error", error.getMessage(), null);
        return new ResponseEntity<>(errorMsg, HttpStatus.OK);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<?> handleMissingInput(HttpMessageNotReadableException error) {
        log.error(error.getMessage());

        Error errorMsg = new Error("Error", "Required Request Body is Missing", null);
        return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ExceptionResponse> handleUnauthorizedException(AuthenticationException error) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("UNAUTHORIZED");
        response.setErrorMessage(error.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<?> handleResourceExistsException(ResourceAlreadyExists error) {

        Error errorMsg = new Error("Error", "The User us already Registered", null);
        return new ResponseEntity<>(errorMsg, HttpStatus.OK);
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
