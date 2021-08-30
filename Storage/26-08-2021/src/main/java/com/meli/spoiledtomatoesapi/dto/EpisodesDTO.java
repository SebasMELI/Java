package com.meli.spoiledtomatoesapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.spoiledtomatoesapi.model.ActorEpisodeModel;
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
public class EpisodesDTO {
    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private Integer number;
    private Timestamp releaseDate;
    private BigDecimal rating;
    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ActorEpisodeModel> episodesModels;
}
