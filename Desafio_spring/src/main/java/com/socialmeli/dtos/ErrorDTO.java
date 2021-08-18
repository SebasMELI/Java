package com.socialmeli.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private int statusCode;
    private String error;

    public ErrorDTO(String message, int statusCode, String error) {
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
    }
}
