package com.meli.spoiledtomatoesapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeasonsDTO {
    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private Timestamp releaseDate;
    private Timestamp endDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SeriesDTO serie;
}
