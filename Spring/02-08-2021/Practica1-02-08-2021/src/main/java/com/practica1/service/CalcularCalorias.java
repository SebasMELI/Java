package com.practica1.service;

import com.practica1.dtos.IngredientesDTO;
import com.practica1.dtos.PlatoDTO;
import com.practica1.dtos.PlatoResponseDTO;
import com.practica1.repository.CalcularIngredientes;

import java.util.*;

public class CalcularCalorias implements ICalcularCalorias {

    private CalcularIngredientes calcularIngredientes;

    public CalcularCalorias() throws Exception {
        try
        {
            this.calcularIngredientes = new CalcularIngredientes();
        }catch (Exception exception){
            throw new Exception(exception.getMessage());
        }

    }

    @Override
    public PlatoResponseDTO calcularCalorias(PlatoDTO plato) throws Exception {

        PlatoResponseDTO platoResponse = new PlatoResponseDTO();
        double calorias = 0;
        List<IngredientesDTO> ingredientes = new ArrayList<>();
        try{

            for (IngredientesDTO ingrediente:plato.getIngredientes()) {
                calorias += this.calcularIngredientes.getCalorias(ingrediente);
                ingredientes.add(this.calcularIngredientes.getIngrediente(ingrediente.getNombre()));
            }

            platoResponse.setCaloriasTotales(calorias);
            platoResponse.setIngredientes(ingredientes);
            platoResponse.setIngredienteMasCalorico(ingredienteMasCalorico(ingredientes));

        }catch (Exception exception){
            throw new Exception(exception.getMessage());
        }

        return platoResponse;
    }

    private IngredientesDTO ingredienteMasCalorico(List<IngredientesDTO> ingredientes){
        return Collections.max(ingredientes, (i1,i2) -> i1.compare(i1,i2));
    }
}
