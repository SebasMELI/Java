package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@RequestBody @Valid StudentDTO rq) {
        //@NotBlank : Comprueba que la secuencia de caracteres anotada no sea nula y que la longitud recortada sea mayor que 0.
        //@NotNull : Comprueba si el elemento anotado no es nulo ni está vacío.
        //@NotEmpty : Comprueba que el valor anotado no sea nulo
        return service.analyzeScores(rq);
    }
}
