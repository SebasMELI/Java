package com.practica1.controllers;

import com.practica1.dtos.HabitacionesDTO;
import com.practica1.dtos.HabitacionesResponseDTO;
import com.practica1.dtos.PropiedadInmobiliariaDTO;
import com.practica1.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalcularMetrosCuadrados {

    @PostMapping("/CalcularMetrosCuadrados")
    public ResponseEntity<ResponseDTO> calcularMetrosCuadrados(@RequestBody PropiedadInmobiliariaDTO propiedadInmobiliaria){

        ResponseDTO responseDTO = new ResponseDTO();
        HabitacionesDTO habitacionMasGrande = new HabitacionesDTO();
        List<HabitacionesResponseDTO> dtoList = new ArrayList<>();
        double totalAncho = 0;
        double totalLargo = 0;
        double maxAncho = 0;
        double maxLargo =  0;
        double totalMetrosCuadrados = 0;


        for (HabitacionesDTO habitacion: propiedadInmobiliaria.getHabitaciones()) {
            totalAncho += habitacion.getAncho();
            totalLargo += habitacion.getLargo();

            if (habitacion.getAncho() > maxAncho && habitacion.getLargo() > maxLargo){
                maxAncho = habitacion.getAncho();
                maxLargo = habitacion.getLargo();
                habitacionMasGrande = habitacion;
            }

            dtoList.add(new HabitacionesResponseDTO(habitacion));
        }

        totalMetrosCuadrados = totalAncho * totalLargo;

        responseDTO.setTotalMetrosCuadrados(totalMetrosCuadrados);
        responseDTO.setValorPropiedad("$" + totalMetrosCuadrados*800);
        responseDTO.setHabitacionMasGrande(habitacionMasGrande);
        responseDTO.setMetrosCuadradosXHabitacion(dtoList);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
