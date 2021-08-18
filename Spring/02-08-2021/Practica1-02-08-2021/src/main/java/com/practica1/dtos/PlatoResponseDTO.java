package com.practica1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoResponseDTO extends PlatoDTO {

    private double caloriasTotales;
    private IngredientesDTO ingredienteMasCalorico;

    public PlatoResponseDTO() {
    }

    public PlatoResponseDTO(PlatoDTO plato){
        super(plato.getIngredientes());
    }
}
