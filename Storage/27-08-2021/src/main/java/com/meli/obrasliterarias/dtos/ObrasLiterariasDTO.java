package com.meli.obrasliterarias.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObrasLiterariasDTO {
    private Long id;
    private String nombreObra;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anio;
}
