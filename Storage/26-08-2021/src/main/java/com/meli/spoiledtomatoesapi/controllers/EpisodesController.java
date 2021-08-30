package com.meli.spoiledtomatoesapi.controllers;

import com.meli.spoiledtomatoesapi.dto.ActorsDTO;
import com.meli.spoiledtomatoesapi.dto.EpisodesDTO;
import com.meli.spoiledtomatoesapi.service.IEpisodesService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/episodes")
public class EpisodesController {

    private IEpisodesService episodesService;
    private ModelMapper modelMapper;

    public EpisodesController(IEpisodesService episodesService) {
        this.episodesService = episodesService;
        this.modelMapper = new ModelMapper();
    }

    // Ejercicio 7: Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @GetMapping("/getEpisodesByActor/{nombres}/{apellidos}")
    public @ResponseBody List<EpisodesDTO> getEpisodesByActor(@PathVariable String nombres, @PathVariable String apellidos){
        return this.episodesService.getEpisodesByActor(nombres, apellidos).stream()
                .map(mapping -> this.modelMapper.map(mapping, EpisodesDTO.class))
                .collect(Collectors.toList());
    }
}
