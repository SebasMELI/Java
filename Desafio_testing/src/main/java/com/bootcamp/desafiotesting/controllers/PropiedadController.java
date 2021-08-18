package com.bootcamp.desafiotesting.controllers;

import com.bootcamp.desafiotesting.dtos.BarrioDTO;
import com.bootcamp.desafiotesting.dtos.CuartoDTO;
import com.bootcamp.desafiotesting.dtos.PropiedadRequestDTO;
import com.bootcamp.desafiotesting.dtos.PropiedadResponseDTO;
import com.bootcamp.desafiotesting.exception.ExededException;
import com.bootcamp.desafiotesting.exception.NoSuchBarrioException;
import com.bootcamp.desafiotesting.model.BarrioModel;
import com.bootcamp.desafiotesting.model.CuartoModel;
import com.bootcamp.desafiotesting.service.IPropiedadService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PropiedadController {

    private IPropiedadService propiedadService;
    private ModelMapper modelMapper;

    public PropiedadController(IPropiedadService propiedadService){
        this.modelMapper = new ModelMapper();
        this.propiedadService = propiedadService;
    }

    @PostMapping("/totalMetrosCuadradosPropiedad")
    public ResponseEntity<PropiedadResponseDTO> totalMetrosCuadradosPropiedad(@RequestBody @Valid PropiedadRequestDTO request){
        return new ResponseEntity<>(modelMapper.map(propiedadService.totalMetrosCuadradosPropiedad(request), PropiedadResponseDTO.class), HttpStatus.OK);
    }

    @PostMapping("/totalSuperficieSinConstruccion")
    public ResponseEntity<PropiedadResponseDTO> totalSuperficieSinConstruccion(@RequestBody @Valid PropiedadRequestDTO request) throws NoSuchBarrioException, ExededException{
        return new ResponseEntity<>(modelMapper.map(propiedadService.totalSuperficieSinConstruccion(request), PropiedadResponseDTO.class), HttpStatus.OK);
    }

    @PostMapping("/precioPropiedad")
    public ResponseEntity<PropiedadResponseDTO> precioPropiedad(@RequestBody @Valid PropiedadRequestDTO request) throws NoSuchBarrioException{
        return new ResponseEntity<>(modelMapper.map(propiedadService.precioPropiedad(request), PropiedadResponseDTO.class), HttpStatus.OK);
    }

    @PostMapping("/cuartoMasGrande")
    public ResponseEntity<CuartoDTO> cuartoMasGrande(@RequestBody @Valid PropiedadRequestDTO request){
        return new ResponseEntity<>(modelMapper.map(propiedadService.cuartoMasGrande(request), CuartoDTO.class), HttpStatus.OK);
    }

    @PostMapping("/metrosPorCuarto")
    public ResponseEntity<List<CuartoDTO>> metrosPorCuarto(@RequestBody @Valid PropiedadRequestDTO request){
        List<CuartoDTO> dtoList = new ArrayList<>();
        List<CuartoModel> cuartoModels = propiedadService.metrosPorCuarto(request);
        for (CuartoModel cuartoModel: cuartoModels)
            dtoList.add(modelMapper.map(cuartoModel, CuartoDTO.class));
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/getBarrios")
    public ResponseEntity<List<BarrioDTO>> getBarrios(){
        List<BarrioDTO> dtoList = new ArrayList<>();
        List<BarrioModel> barrioModels = propiedadService.getBarrios();
        for (BarrioModel barrioModel: barrioModels)
            dtoList.add(modelMapper.map(barrioModel, BarrioDTO.class));
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/getBarrioPorNombre/{nombre}")
    public ResponseEntity<BarrioDTO> getBarrioPorNombre(@PathVariable String nombre) throws NoSuchBarrioException {
        return new ResponseEntity<>(modelMapper.map(propiedadService.getBarrioPorNombre(nombre), BarrioDTO.class), HttpStatus.OK);
    }
}
