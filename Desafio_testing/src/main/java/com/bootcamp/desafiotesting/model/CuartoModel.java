package com.bootcamp.desafiotesting.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CuartoModel {

    private String room_name;
    private Double room_width;
    private Double room_length;
    private Double cantidad_metros_cuadrados;

}
