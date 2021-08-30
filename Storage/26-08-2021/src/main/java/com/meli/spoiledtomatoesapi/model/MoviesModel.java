package com.meli.spoiledtomatoesapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "movies")
public class MoviesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    private String title;
    private BigDecimal rating;
    private int awards;
    @Column(name = "release_date")
    private Timestamp releaseDate;
    private Integer length;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private GenresModel genresModel;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "favoriteMovie")
    private List<ActorsModel> actorsModel;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "moviesModel")
    private List<ActorMovieModel> actorMovieModels;
}
