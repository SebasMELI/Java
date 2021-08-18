package com.practica1.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDTO {
    private double totalMetrosCuadrados;
    private String valorPropiedad;
    private HabitacionesDTO habitacionMasGrande;
    private List<HabitacionesResponseDTO> metrosCuadradosXHabitacion;

}
