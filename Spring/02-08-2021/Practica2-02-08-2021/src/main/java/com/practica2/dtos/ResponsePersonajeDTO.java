package com.practica2.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePersonajeDTO {

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PersonajeDTO> personajes;

    public ResponsePersonajeDTO(String message) {
        this.message = message;
    }
}
