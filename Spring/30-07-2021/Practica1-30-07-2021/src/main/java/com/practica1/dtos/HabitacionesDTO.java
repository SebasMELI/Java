package com.practica1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitacionesDTO {
    protected String nombre;
    protected double ancho;
    protected double largo;

    public HabitacionesDTO() {
    }

    public HabitacionesDTO(HabitacionesDTO habitaciones) {
        this.nombre = habitaciones.nombre;
        this.ancho = habitaciones.ancho;
        this.largo = habitaciones.largo;
    }
}
