package com.practica2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    @GetMapping("/calcularEdad/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio)
    {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        return Integer.toString(Period.between(fechaNacimiento, fechaHoy).getYears());
    }
}
