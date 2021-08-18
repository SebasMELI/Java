package com.bootcamp.desafiotesting.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {

    private final String code;
    private final String message;

    public ErrorDTO(@NonNull String code, @NonNull String message) {
        this.code = code;
        this.message = message;
    }
}
