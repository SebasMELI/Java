package com.meli.spoiledtomatoesapi.repository;

import com.meli.spoiledtomatoesapi.model.ActorsModel;
import com.meli.spoiledtomatoesapi.model.MoviesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<MoviesModel, Integer> {

    @Query("select a From MoviesModel m " +
            "join ActorMovieModel am on m.id = am.moviesModel.id " +
            "join ActorsModel a on am.actorsModel.id = a.id " +
            "where m.title = :movie")
    List<ActorsModel> findByTitleEquals(@Param("movie") String movie);

    @Query("select m From MoviesModel m " +
            "join ActorMovieModel am on m.id = am.moviesModel.id " +
            "join ActorsModel a on am.actorsModel.id = a.id " +
            "where a.rating > :rating")
    List<MoviesModel> findByRatingGreaterThan(@Param("rating")BigDecimal rating);

    @Query("select m from MoviesModel m " +
            "join GenresModel g on g.id = m.genresModel.id " +
            "where g.name = :nombre")
    List<MoviesModel> findByGenresModelEquals(@Param("nombre") String nombre);
}
