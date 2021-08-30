package com.meli.spoiledtomatoesapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

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
}