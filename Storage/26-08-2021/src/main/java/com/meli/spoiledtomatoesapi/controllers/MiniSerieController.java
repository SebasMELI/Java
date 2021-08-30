package com.meli.spoiledtomatoesapi.controllers;

import com.meli.spoiledtomatoesapi.dto.MiniSerieDTO;
import com.meli.spoiledtomatoesapi.model.MiniSerieModel;
import com.meli.spoiledtomatoesapi.service.IMiniserieService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/miniserie")
public class MiniSerieController {

    private IMiniserieService miniserieService;
    private ModelMapper modelMapper;

    public MiniSerieController(IMiniserieService miniserieService){
        this.modelMapper = new ModelMapper();
        this.modelMapper.typeMap(MiniSerieModel.class, MiniSerieDTO.class)
                .addMapping(MiniSerieModel::getGenresByGenreId, MiniSerieDTO::setGenresByGenreId);
        this.miniserieService = miniserieService;
    }

    @GetMapping("/getMiniSerie/{id}")
    public ResponseEntity<MiniSerieDTO> getMiniSerie(@PathVariable Long id){
        return new ResponseEntity<>(this.modelMapper.map(this.miniserieService.getMiniSerie(id), MiniSerieDTO.class), HttpStatus.OK);
    }

    @GetMapping("/getAllMiniSeries")
    public ResponseEntity<List<MiniSerieDTO>> getAllMiniSeries(){
        return new ResponseEntity<>(this.miniserieService.getAllMiniSeries().stream()
                .map(mapping -> this.modelMapper.map(mapping, MiniSerieDTO.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/createMiniSerie")
    public ResponseEntity<MiniSerieDTO> createMiniSerie(@RequestBody MiniSerieDTO miniSerie){
        return new ResponseEntity<>(this.modelMapper.map(
                this.miniserieService.createMiniSerie(
                        this.modelMapper.map(miniSerie, MiniSerieModel.class))
                , MiniSerieDTO.class)
        , HttpStatus.OK);
    }

    @PutMapping("/updateMiniSerie")
    public ResponseEntity<MiniSerieDTO> updateMiniSerie(@RequestBody MiniSerieDTO miniSerie){
        return new ResponseEntity<>(this.modelMapper.map(
                this.miniserieService.updateMiniSerie(
                        this.modelMapper.map(miniSerie, MiniSerieModel.class))
                , MiniSerieDTO.class)
        , HttpStatus.OK);
    }

    @DeleteMapping("/deleteMiniSerie/{id}")
    public void deleteMiniSerie(@PathVariable Long id){
       this.miniserieService.deleteMiniSerie(id);
    }
}
