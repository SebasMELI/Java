package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ObtenerDiplomaExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex){
        return new ResponseEntity<>(new ErrorDTO(ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage(),ex.getClass().getCanonicalName()), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException ex){
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage(),ex.getClass().getCanonicalName()), HttpStatus.BAD_GATEWAY);
    }
}
