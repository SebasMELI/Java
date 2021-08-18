package com.practica2.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica2.models.Personaje;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StarWarsRepository implements IStarWarsRepository{

    private List<Personaje> lstPersonajes;

    public StarWarsRepository(){
        this.lstPersonajes = new ArrayList<>();
    }

    @Override
    public void getPersonajes() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        File file;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
            this.lstPersonajes = objectMapper.readValue(file, new TypeReference<List<Personaje>>() {});
        }catch ( Exception exception)
        {
            throw new Exception(exception.getMessage());
        }

    }

    @Override
    public List<Personaje> getPersonajesPorNombre(String nombre) {
        return this.lstPersonajes.stream()
                .filter(p -> p.getName().contains(nombre))
                .collect(Collectors.toList());
    }
}
