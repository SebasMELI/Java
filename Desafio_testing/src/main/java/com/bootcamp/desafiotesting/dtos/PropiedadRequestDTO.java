package com.bootcamp.desafiotesting.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropiedadRequestDTO {
    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp="([A-Z])[\\s|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String prop_name;

    @NotNull(message = "El ancho del terreno no puede estar vacío.")
    @DecimalMax(value = "75.0", message = "El máximo ancho permitido por terreno es de 75 mts.")
    private Double prop_land_width;

    @NotNull(message = "El largo del terreno no puede estar vacío.")
    @DecimalMax(value = "100.0", message = "El máximo largo permitido por terreno es de 100 mts.")
    private Double prop_land_length;

    @NotBlank(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String district_name;

    @NotNull(message = "El precio del metro cuadrado construido de un barrio no puede estar vacío.")
    @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado construido no puede superar los 4000 U$S.")
    private Integer district_built_price;

    @NotNull(message = "El precio del metro cuadrado construido de un barrio no puede estar vacío.")
    @Max(value = 1000, message = "El precio del metro cuadrado construido de un barrio no puede estar vacío.")
    private Integer district_unbuilt_price;

    @NotEmpty(message = "La propiedad debe de tener cuartos.")
    private List<@Valid CuartoDTO> rooms;
}
