package com.bootcamp.desafiotesting.service;

import com.bootcamp.desafiotesting.dtos.PropiedadRequestDTO;
import com.bootcamp.desafiotesting.exception.ExededException;
import com.bootcamp.desafiotesting.exception.NoSuchBarrioException;
import com.bootcamp.desafiotesting.model.BarrioModel;
import com.bootcamp.desafiotesting.model.CuartoModel;
import com.bootcamp.desafiotesting.model.PropiedadModel;

import java.util.List;

public interface IPropiedadService {
    public PropiedadModel totalMetrosCuadradosPropiedad(PropiedadRequestDTO request);
    public PropiedadModel totalSuperficieSinConstruccion(PropiedadRequestDTO request) throws NoSuchBarrioException, ExededException;
    public PropiedadModel precioPropiedad(PropiedadRequestDTO request) throws NoSuchBarrioException;
    public CuartoModel cuartoMasGrande(PropiedadRequestDTO request);
    public List<CuartoModel> metrosPorCuarto(PropiedadRequestDTO request);
    public List<BarrioModel> getBarrios();
    public BarrioModel getBarrioPorNombre(String name) throws NoSuchBarrioException;
}
