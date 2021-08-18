package com.practica1.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatoDTO {

    public PlatoDTO() {
    }

    public PlatoDTO(List<IngredientesDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nombre;
    private List<IngredientesDTO> ingredientes;
}
