package com.meli.spoiledtomatoesapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "episodes")
public class EpisodesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    private String title;
    private Integer number;
    @Column(name = "release_date")
    private Timestamp releaseDate;
    private BigDecimal rating;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "episodesModel")
    private List<ActorEpisodeModel> episodesModels;
}
