package com.practica1.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PropiedadInmobiliariaDTO {
    private String nombre;
    private String dirección;
    private List<HabitacionesDTO> habitaciones;
}
