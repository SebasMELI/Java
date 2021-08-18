package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
//@NotBlank : Comprueba que la secuencia de caracteres anotada no sea nula y que la longitud recortada sea mayor que 0.
//@NotNull : Comprueba si el elemento anotado no es nulo ni está vacío.
//@NotEmpty : Comprueba que el valor anotado no sea nulo
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp="([A-Z])[\\s|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del alumno comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String studentName;
    private String message;
    private Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacía.")
    private List<@Valid SubjectDTO> subjects;
}
