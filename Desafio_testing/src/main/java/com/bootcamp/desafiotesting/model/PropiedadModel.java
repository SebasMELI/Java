package com.bootcamp.desafiotesting.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropiedadModel {
    private String prop_name;
    private Double prop_total_prop;
    private String barrio_name;
    private Double terreno_faltante;
    private Double precio_terreno;
}
