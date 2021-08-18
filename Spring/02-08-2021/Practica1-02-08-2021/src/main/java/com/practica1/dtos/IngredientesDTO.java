package com.practica1.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.practica1.models.Food;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class IngredientesDTO implements Comparator<IngredientesDTO> {
    private String nombre;
    private double calorias;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double peso;

    public IngredientesDTO mapIngrediente(Food food){

        IngredientesDTO ingredientes = new IngredientesDTO();
        ingredientes.setNombre(food.getName());
        ingredientes.setCalorias(food.getCalories());
        return ingredientes;
    }

    @Override
    public int compare(IngredientesDTO o1, IngredientesDTO o2) {
        if (o1.getCalorias() > o2.getCalorias())
            return 1;
        else if (o1.getCalorias() < o2.getCalorias())
            return -1;
        return 0;
    }
}
