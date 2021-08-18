package com.practica2.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAlumnosDTO{

    private String mensaje;
    private double promedio;
    private String alumno;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String promedioSuperior;
}
