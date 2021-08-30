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
@Table(name = "actors")
public class ActorsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private BigDecimal rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_movie_id", columnDefinition = "id")
    private MoviesModel favoriteMovie;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actors")
    private List<ActorEpisodeModel> actorEpisodeModels;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actorsModel")
    private List<ActorMovieModel> actorMovieModels;
}
