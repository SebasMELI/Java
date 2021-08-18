package com.practica2.repository;

import com.practica2.models.Personaje;

import java.util.List;

public interface IStarWarsRepository {

    public List<Personaje> getPersonajesPorNombre(String nombre);
    public void getPersonajes() throws Exception;
}
