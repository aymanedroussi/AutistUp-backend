package com.autistup.app.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice(basePackages ="com.autistup.app")
public class AppExceptionHandler {

    @ExceptionHandler(value ={ParentException.class})
    public ResponseEntity<Object> userException(ParentException ex, WebRequest webRequest){
        ErrorMessage errorMessage=new ErrorMessage(new Date(),ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value =Exception.class)
    public ResponseEntity<Object> othersExceptions(Exception ex, WebRequest webRequest){
        ErrorMessage errorMessage=new ErrorMessage(new Date(),ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
