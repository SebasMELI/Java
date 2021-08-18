package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private String error;

    public ErrorDTO(String message, String error) {
        this.message = message;
        this.error = error;
    }
}
