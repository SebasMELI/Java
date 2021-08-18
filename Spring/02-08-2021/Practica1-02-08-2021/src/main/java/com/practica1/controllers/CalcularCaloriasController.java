package com.practica1.controllers;

import com.practica1.dtos.BadResponseDTO;
import com.practica1.dtos.PlatoDTO;
import com.practica1.service.CalcularCalorias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularCaloriasController {

    private CalcularCalorias calcularCalorias;

    public CalcularCaloriasController() throws Exception {
        try{
        this.calcularCalorias = new CalcularCalorias();
    }catch (Exception exception){
        throw new Exception(exception.getMessage());
    }
    }

    @PostMapping("/calcularcalorias")
    public ResponseEntity<?> calcularCalorias(@RequestBody PlatoDTO plato){
        try {
            return new ResponseEntity(this.calcularCalorias.calcularCalorias(plato), HttpStatus.OK);
        }catch (Exception exception)
        {
            return new ResponseEntity(new BadResponseDTO(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
