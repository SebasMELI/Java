package com.meli.obrasliterarias.controllers;

import com.meli.obrasliterarias.domain.ObrasLiterarias;
import com.meli.obrasliterarias.dtos.ObrasLiterariasDTO;
import com.meli.obrasliterarias.service.IObrasLiterariasService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/obrasliterarias")
public class ObrasLiterariasController {

    private ModelMapper modelMapper;
    private IObrasLiterariasService obrasLiterariasService;

    public ObrasLiterariasController(IObrasLiterariasService obrasLiterariasService) {
        this.modelMapper = new ModelMapper();
        this.obrasLiterariasService = obrasLiterariasService;
    }

    @PostMapping("/save")
    public void saveObrasLiterarias(@RequestBody ObrasLiterariasDTO obraLiteraria){
        this.obrasLiterariasService.saveObrasLiterarias(this.modelMapper.map(obraLiteraria, ObrasLiterarias.class));
    }

    @GetMapping("/getObrasByAuthor/{autor}")
    public @ResponseBody List<ObrasLiterariasDTO> getObrasByAuthor(@PathVariable String autor){
        return this.obrasLiterariasService.getObrasByAuthor(autor).stream()
                .map(mapping -> this.modelMapper.map(mapping, ObrasLiterariasDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/getObrasByNombre/{nombre}")
    public @ResponseBody List<ObrasLiterariasDTO> getObrasByNombre(@PathVariable String nombre){
        return this.obrasLiterariasService.getObrasByNombre(nombre).stream()
                .map(mapping -> this.modelMapper.map(mapping, ObrasLiterariasDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/getObrasByCantidadPaginas/{cantidad}")
    public @ResponseBody List<ObrasLiterariasDTO> getObrasByCantidadPaginas(@PathVariable Integer cantidad){
        return this.obrasLiterariasService.getObrasByCantidadPaginas(cantidad).stream()
                .map(mapping -> this.modelMapper.map(mapping, ObrasLiterariasDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/getObrasByAnioMayor/{anio}")
    public @ResponseBody List<ObrasLiterariasDTO> getObrasByAnioMayor(@PathVariable Integer anio){
        return this.obrasLiterariasService.getObrasByAnioMayor(anio).stream()
                .map(mapping -> this.modelMapper.map(mapping, ObrasLiterariasDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/getObrasByAnioMenor/{anio}")
    public @ResponseBody List<ObrasLiterariasDTO> getObrasByAnioMenor(@PathVariable Integer anio){
        return this.obrasLiterariasService.getObrasByAnioMenor(anio).stream()
                .map(mapping -> this.modelMapper.map(mapping, ObrasLiterariasDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/getObrasByEditorial/{editorial}")
    public @ResponseBody List<ObrasLiterariasDTO> getObrasByEditorial(@PathVariable String editorial){
        return this.obrasLiterariasService.getObrasByEditorial(editorial).stream()
                .map(mapping -> this.modelMapper.map(mapping, ObrasLiterariasDTO.class))
                .collect(Collectors.toList());
    }
}
