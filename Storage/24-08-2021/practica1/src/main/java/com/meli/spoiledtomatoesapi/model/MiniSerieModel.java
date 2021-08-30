package com.meli.spoiledtomatoesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "mini_serie")
public class MiniSerieModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "awards")
    private Integer awards;
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Double rating;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "id", columnDefinition = "INT(10) UNSIGNED")
    private GenresModel genresByGenreId;

}
