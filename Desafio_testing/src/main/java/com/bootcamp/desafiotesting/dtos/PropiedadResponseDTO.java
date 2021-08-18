package com.bootcamp.desafiotesting.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropiedadResponseDTO {
    private String prop_name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double prop_total_prop;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String barrio_name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double terreno_faltante;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double precio_terreno;
}
