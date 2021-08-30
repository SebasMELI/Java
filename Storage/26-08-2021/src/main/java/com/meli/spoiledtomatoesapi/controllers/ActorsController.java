package com.meli.spoiledtomatoesapi.controllers;

import com.meli.spoiledtomatoesapi.dto.ActorsDTO;
import com.meli.spoiledtomatoesapi.service.IActorsService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    private IActorsService actorsService;
    private ModelMapper modelMapper;

    public ActorsController(IActorsService actorsService){
        this.actorsService = actorsService;
        this.modelMapper = new ModelMapper();
    }

    // Ejercicio 1: Listar todos los actores que tengan declarada una película favorita.
    @GetMapping("/getActorsByFavoriteMovie")
    public @ResponseBody List<ActorsDTO> getActorsByFavoriteMovie(){
        return this.actorsService.getActorsByFavoriteMovie().stream()
                .map(mapping -> this.modelMapper.map(mapping, ActorsDTO.class))
                .collect(Collectors.toList());
    }

    // Ejercicio 2; Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/getActorsByRating/{rating}")
    public @ResponseBody List<ActorsDTO> getActorsByRating(@PathVariable BigDecimal rating){
        return this.actorsService.getActorsByRating(rating).stream()
                .map(mapping -> this.modelMapper.map(mapping, ActorsDTO.class))
                .collect(Collectors.toList());
    }
}
