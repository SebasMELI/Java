package com.practica1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica1.dtos.IngredientesDTO;
import com.practica1.models.Food;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

public class CalcularIngredientes implements ICalcularIngredientes{

    private List<Food> food;

    public CalcularIngredientes() throws Exception {
        try {
            this.food = calcularCalorias();
        }catch ( Exception exception)
        {
            throw new Exception(exception.getMessage());
        }
    }

    @Override
    public List<Food> calcularCalorias() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        File file;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
            this.food = objectMapper.readValue(file, new TypeReference<List<Food>>() {});
        }catch ( Exception exception)
        {
            throw new Exception(exception.getMessage());
        }

        return this.food;
    }

    @Override
    public double getCalorias(IngredientesDTO ingrediente) {
        return this.food
                .stream()
                .filter( food -> food.getName().equals(ingrediente.getNombre()))
                .findFirst().orElseThrow().getCalories();
    }

    @Override
    public IngredientesDTO getIngrediente(String nombreIngrediente){

        Food foode = this.food
                .stream()
                .filter( food -> food.getName().equals(nombreIngrediente))
                .findFirst().orElseThrow();

        return new IngredientesDTO().mapIngrediente(foode);
    }


}
