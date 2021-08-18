package com.practica2.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlumnosDTO {
    private String nombre;
    private List<AsignaturasDTO> asignaturas;
}
