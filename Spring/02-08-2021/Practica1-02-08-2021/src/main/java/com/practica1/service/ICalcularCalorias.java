package com.practica1.service;

import com.practica1.dtos.PlatoDTO;
import com.practica1.dtos.PlatoResponseDTO;

public interface ICalcularCalorias {

    public PlatoResponseDTO calcularCalorias(PlatoDTO plato) throws Exception;
}
