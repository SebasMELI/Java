package com.practica1.repository;

import com.practica1.dtos.IngredientesDTO;
import com.practica1.models.Food;

import java.util.List;

public interface ICalcularIngredientes{

    public List<Food> calcularCalorias() throws Exception;
    public double getCalorias(IngredientesDTO ingrediente);
    public IngredientesDTO getIngrediente(String nombreIngrediente);
}
