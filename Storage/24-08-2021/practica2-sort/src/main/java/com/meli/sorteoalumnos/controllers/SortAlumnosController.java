package com.meli.sorteoalumnos.controllers;

import com.meli.sorteoalumnos.dtos.AlumnosDTO;
import com.meli.sorteoalumnos.service.ISortAlumnosService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sort")
public class SortAlumnosController {

    private ISortAlumnosService sortAlumnosService;
    private ModelMapper modelMapper;

    public SortAlumnosController(ISortAlumnosService sortAlumnosService){
        this.sortAlumnosService = sortAlumnosService;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping("/getSortAlumnos")
    public ResponseEntity<List<AlumnosDTO>> getSortAlumnos(){
        return ResponseEntity.ok(this.sortAlumnosService.getSortAlumnos().stream()
                .map(mapping -> this.modelMapper.map(mapping, AlumnosDTO.class))
                .collect(Collectors.toList()));
    }
}
