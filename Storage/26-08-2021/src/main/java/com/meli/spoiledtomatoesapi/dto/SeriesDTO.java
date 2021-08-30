package com.meli.spoiledtomatoesapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeriesDTO {
    private int id;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("updated_at")
    private Timestamp updatedAt;
    private String title;
    @JsonProperty("release_date")
    private Timestamp releaseDate;
    @JsonProperty("end_date")
    private Timestamp endDate;
}
