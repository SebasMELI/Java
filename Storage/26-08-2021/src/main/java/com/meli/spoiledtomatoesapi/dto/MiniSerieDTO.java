package com.meli.spoiledtomatoesapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.spoiledtomatoesapi.model.GenresModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerieDTO {
    private long id;
    private Integer awards;
    private String name;
    private Double rating;
    private Integer genreId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GenresModel genresByGenreId;
}
