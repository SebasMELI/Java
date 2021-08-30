package com.meli.spoiledtomatoesapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenresDTO {
    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
    private int ranking;
    private byte active;
    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MoviesDTO> moviesModels;
}