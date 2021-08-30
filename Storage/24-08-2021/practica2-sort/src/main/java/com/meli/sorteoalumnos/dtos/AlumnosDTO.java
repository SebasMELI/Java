package com.meli.sorteoalumnos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlumnosDTO {
    private Long id;
    private String name;
    private String lastName;
}
