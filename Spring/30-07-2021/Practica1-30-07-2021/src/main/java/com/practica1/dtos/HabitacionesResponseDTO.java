package com.practica1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitacionesResponseDTO extends HabitacionesDTO {

    private double totalMetrosCuadrados;

    public HabitacionesResponseDTO(HabitacionesDTO habitaciones){
        super(habitaciones);
        this.totalMetrosCuadrados = habitaciones.ancho * habitaciones.largo;
    }
}
