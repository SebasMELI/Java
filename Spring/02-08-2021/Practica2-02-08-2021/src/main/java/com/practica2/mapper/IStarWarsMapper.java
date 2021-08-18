package com.practica2.mapper;

import com.practica2.dtos.PersonajeDTO;
import com.practica2.models.Personaje;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IStarWarsMapper {
    public PersonajeDTO personajeToPersonajeDTO(Personaje personaje);
    public Personaje personajeDTOToPersonaje(PersonajeDTO personaje);
    public List<PersonajeDTO> personajeToPersonajeDTO(List<Personaje> personaje);
    public List<Personaje> personajeDTOToPersonaje(List<PersonajeDTO> personaje);
}
