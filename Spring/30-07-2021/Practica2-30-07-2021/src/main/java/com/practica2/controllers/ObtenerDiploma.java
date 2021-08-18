package com.practica2.controllers;

import com.practica2.dtos.AlumnosDTO;
import com.practica2.dtos.AsignaturasDTO;
import com.practica2.dtos.ResponseAlumnosDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObtenerDiploma {

    @PostMapping("/generarDiploma")
    public ResponseEntity<ResponseAlumnosDTO> generarDiploma(@RequestBody AlumnosDTO alumno){

        ResponseAlumnosDTO responseAlumnos = new ResponseAlumnosDTO();

        for (AsignaturasDTO asignatura: alumno.getAsignaturas()) {
            responseAlumnos.setPromedio(responseAlumnos.getPromedio() + asignatura.getNota());
        }

        responseAlumnos.setMensaje("Diploma");
        responseAlumnos.setPromedio(responseAlumnos.getPromedio()/alumno.getAsignaturas().size());
        responseAlumnos.setAlumno(alumno.getNombre());
        if(responseAlumnos.getPromedio() > 9)
            responseAlumnos.setPromedioSuperior("You Rock!");

        return new ResponseEntity<>(responseAlumnos, HttpStatus.OK);
    }
}
