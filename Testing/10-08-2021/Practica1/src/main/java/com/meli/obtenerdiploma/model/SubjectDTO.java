package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
//@NotBlank : Comprueba que la secuencia de caracteres anotada no sea nula y que la longitud recortada sea mayor que 0.
//@NotNull : Comprueba si el elemento anotado no es nulo ni está vacío.
//@NotEmpty : Comprueba que el valor anotado no sea nulo
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp="([A-Z])[\\s|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    private String name;
    @NotNull(message = "La nota no puede estar vacía.")
    @DecimalMin(value = "0.0", message = "La mínima nota es 0.0.")
    @DecimalMax(value = "10.0", message = "La máxima nota es 10.0.")
    private Double score;
}
