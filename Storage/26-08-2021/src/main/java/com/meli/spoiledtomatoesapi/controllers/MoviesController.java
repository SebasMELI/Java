package com.meli.spoiledtomatoesapi.controllers;

import com.meli.spoiledtomatoesapi.dto.ActorsDTO;
import com.meli.spoiledtomatoesapi.dto.MoviesDTO;
import com.meli.spoiledtomatoesapi.model.MoviesModel;
import com.meli.spoiledtomatoesapi.service.IMoviesService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private IMoviesService moviesService;
    private ModelMapper modelMapper;

    public MoviesController(IMoviesService moviesService) {
        this.moviesService = moviesService;
        this.modelMapper = new ModelMapper();
    }

    // Ejercicio 3: Listar todos los actores que trabajan en la <película recibida por parámetro>
    @GetMapping("/getActorsByMovieTitle/{name}")
    public @ResponseBody List<ActorsDTO> getActorsByMovieTitle(@PathVariable String name){
        return this.moviesService.getActorsByMovieTitle(name).stream()
                .map(mapping -> this.modelMapper.map(mapping, ActorsDTO.class))
                .collect(Collectors.toList());
    }

    //Ejercicio 4: Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/getMoviesByActorsByRating/{rating}")
    public @ResponseBody List<MoviesDTO> getMoviesByActorsByRating(@PathVariable BigDecimal rating){
        return this.moviesService.getMoviesByActorsByRating(rating).stream()
                .map(mapping -> this.modelMapper.map(mapping, MoviesDTO.class))
                .collect(Collectors.toList());
    }

    //Ejercicio 5: Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @GetMapping("/getMoviesByGenreName/{name}")
    public @ResponseBody List<MoviesDTO> getMoviesByGenreName(@PathVariable String name){
        return this.moviesService.getMoviesByGenreName(name).stream()
                .map(mapping -> this.modelMapper.map(mapping, MoviesDTO.class))
                .collect(Collectors.toList());
    }

}
