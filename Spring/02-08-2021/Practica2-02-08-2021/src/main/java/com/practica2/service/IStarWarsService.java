package com.practica2.service;

import com.practica2.dtos.ResponsePersonajeDTO;

public interface IStarWarsService {

    public ResponsePersonajeDTO getPersonaje(String nombre) throws Exception;
}
