package com.bootcamp.desafiotesting.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BarrioDTO {
    private String name;
    private Double area;
    private Double price;
}
