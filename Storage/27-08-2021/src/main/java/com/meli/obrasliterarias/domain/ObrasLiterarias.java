package com.meli.obrasliterarias.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "obras")
public class ObrasLiterarias {
    @Id
    private Long id;
    private String nombreObra;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anio;
}
