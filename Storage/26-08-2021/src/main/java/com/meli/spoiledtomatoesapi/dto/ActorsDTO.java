package com.meli.spoiledtomatoesapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActorsDTO {
    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MoviesDTO favoriteMovie;
}
