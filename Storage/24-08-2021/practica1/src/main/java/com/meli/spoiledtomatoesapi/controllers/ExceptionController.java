package com.meli.spoiledtomatoesapi.controllers;

import com.meli.spoiledtomatoesapi.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(Exception e) {
        ErrorDTO error = new ErrorDTO(e.fillInStackTrace().getMessage(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
