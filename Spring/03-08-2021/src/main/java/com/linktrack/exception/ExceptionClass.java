package com.linktrack.exception;


import com.linktrack.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionClass {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO Exception(Exception e){
        return new ErrorDTO(e.getMessage(),e.getClass().getCanonicalName());
    }
}
