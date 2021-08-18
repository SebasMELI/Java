package com.practica2.mapper;

import com.practica2.dtos.PersonajeDTO;
import com.practica2.models.Personaje;

import java.util.ArrayList;
import java.util.List;

public class StarWarsMapper implements IStarWarsMapper{
    @Override
    public PersonajeDTO personajeToPersonajeDTO(Personaje personaje) {
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setBirthYear(personaje.getBirth_year());
        personajeDTO.setGender(personaje.getGender());
        personajeDTO.setEyeColor(personaje.getEye_color());
        personajeDTO.setHeight(personaje.getHeight());
        personajeDTO.setHomeworld(personaje.getHomeworld());
        personajeDTO.setSpecies(personaje.getSpecies());
        personajeDTO.setMass(personaje.getMass());
        personajeDTO.setName(personaje.getName());
        personajeDTO.setSkinColor(personaje.getSkin_color());
        personajeDTO.setHairColor(personaje.getHair_color());
        return personajeDTO;
    }

    @Override
    public Personaje personajeDTOToPersonaje(PersonajeDTO personaje) {
        Personaje persona = new Personaje();
        persona.setBirth_year(personaje.getBirthYear());
        persona.setGender(personaje.getGender());
        persona.setEye_color(personaje.getEyeColor());
        persona.setHeight(personaje.getHeight());
        persona.setHomeworld(personaje.getHomeworld());
        persona.setSpecies(personaje.getSpecies());
        persona.setMass(personaje.getMass());
        persona.setName(personaje.getName());
        persona.setSkin_color(personaje.getSkinColor());
        persona.setHair_color(personaje.getHairColor());
        return persona;
    }

    @Override
    public List<PersonajeDTO> personajeToPersonajeDTO(List<Personaje> personaje) {
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        for (Personaje persona: personaje) {
            PersonajeDTO personajeDTO = new PersonajeDTO();
            personajeDTO.setBirthYear(persona.getBirth_year());
            personajeDTO.setGender(persona.getGender());
            personajeDTO.setEyeColor(persona.getEye_color());
            personajeDTO.setHeight(persona.getHeight());
            personajeDTO.setHomeworld(persona.getHomeworld());
            personajeDTO.setSpecies(persona.getSpecies());
            personajeDTO.setMass(persona.getMass());
            personajeDTO.setName(persona.getName());
            personajeDTO.setSkinColor(persona.getSkin_color());
            personajeDTO.setHairColor(persona.getHair_color());
            personajesDTO.add(personajeDTO);
        }
        return personajesDTO;
    }

    @Override
    public List<Personaje> personajeDTOToPersonaje(List<PersonajeDTO> personaje) {
        List<Personaje> persona = new ArrayList<>();
        for (PersonajeDTO personajeDTO :personaje) {
            Personaje person = new Personaje();
            person.setBirth_year(personajeDTO.getBirthYear());
            person.setGender(personajeDTO.getGender());
            person.setEye_color(personajeDTO.getEyeColor());
            person.setHeight(personajeDTO.getHeight());
            person.setHomeworld(personajeDTO.getHomeworld());
            person.setSpecies(personajeDTO.getSpecies());
            person.setMass(personajeDTO.getMass());
            person.setName(personajeDTO.getName());
            person.setSkin_color(personajeDTO.getSkinColor());
            person.setHair_color(personajeDTO.getHairColor());
            persona.add(person);
        }
        return persona;
    }
}
