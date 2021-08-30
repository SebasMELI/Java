package com.meli.spoiledtomatoesapi.controllers;

import com.meli.spoiledtomatoesapi.dto.SeriesDTO;
import com.meli.spoiledtomatoesapi.service.ISeriesService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private ModelMapper modelMapper;
    private ISeriesService seriesService;

    public SeriesController(ISeriesService seriesService) {
        this.modelMapper = new ModelMapper();
        this.seriesService = seriesService;
    }

    // Ejercicio 6: Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @GetMapping("/getSeriesByTemps/{temps}")
    public @ResponseBody List<SeriesDTO> getSeriesByTemps(@PathVariable Long temps){
        return this.seriesService.getSeriesByTemps(temps).stream()
                .map(mapping -> this.modelMapper.map(mapping, SeriesDTO.class))
                .collect(Collectors.toList());
    }
}
