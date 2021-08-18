package com.practica1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadResponseDTO {

    private String message;

    public BadResponseDTO(String message) {
        this.message = message;
    }
}
