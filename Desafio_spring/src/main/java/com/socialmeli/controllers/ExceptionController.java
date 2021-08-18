package com.socialmeli.controllers;

import com.socialmeli.dtos.ErrorDTO;
import com.socialmeli.exceptions.PostException;
import com.socialmeli.exceptions.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO UserException(UserException e){
        return new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST.value(), e.getClass().getCanonicalName());
    }

    @ExceptionHandler(PostException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO UserException(PostException e){
        return new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST.value(), e.getClass().getCanonicalName());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO Exception(Exception e){
        return new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST.value(), e.getClass().getCanonicalName());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorDTO UserException(HttpMessageNotReadableException e){
        return new ErrorDTO("Uno o varios parametros no son validos",HttpStatus.CONFLICT.value(), e.getClass().getCanonicalName());
    }
}
