package com.meli.spoiledtomatoesapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.spoiledtomatoesapi.model.GenresModel;
import com.meli.spoiledtomatoesapi.model.MoviesModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDTO {
    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private BigDecimal rating;
    private int awards;
    private Timestamp releaseDate;
    private Integer length;
    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ActorsDTO> actorsModel;
    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MoviesModel> moviesModels;
    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GenresModel genresModel;
}
