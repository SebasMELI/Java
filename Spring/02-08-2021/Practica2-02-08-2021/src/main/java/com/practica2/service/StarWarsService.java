package com.practica2.service;

import com.practica2.dtos.PersonajeDTO;
import com.practica2.dtos.ResponsePersonajeDTO;
import com.practica2.mapper.StarWarsMapper;
import com.practica2.models.Personaje;
import com.practica2.repository.StarWarsRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StarWarsService implements IStarWarsService{

    private final StarWarsRepository starWarsRepository;

    public StarWarsService(){
        this.starWarsRepository = new StarWarsRepository();
    }

    @Override
    public ResponsePersonajeDTO getPersonaje(String nombre) throws Exception {

        ResponsePersonajeDTO responsePersonaje = new ResponsePersonajeDTO();
        StarWarsMapper starWarsMapper = new StarWarsMapper();
        this.starWarsRepository.getPersonajes();
        try{

            List<Personaje> personajeList = this.starWarsRepository.getPersonajesPorNombre(nombre);
            if(personajeList.size() == 0)
                throw new Exception("No se encontraron personajes");

            responsePersonaje.setMessage("Personajes encontrados");
            responsePersonaje.setPersonajes(starWarsMapper.personajeToPersonajeDTO(personajeList));
        }catch ( Exception exception)
        {
            responsePersonaje.setMessage(exception.getMessage());
        }

        return responsePersonaje;
    }
}
