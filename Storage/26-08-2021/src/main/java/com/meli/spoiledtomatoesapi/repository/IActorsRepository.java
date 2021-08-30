package com.meli.spoiledtomatoesapi.repository;

import com.meli.spoiledtomatoesapi.model.ActorsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorsRepository extends JpaRepository<ActorsModel,Integer> {

    @Query("From ActorsModel a where a.favoriteMovie is not null")
    List<ActorsModel> findByFavoriteMovieId();
    @Query("From ActorsModel a where a.rating > :rating")
    List<ActorsModel> findByRatingGreaterThan(@Param("rating") BigDecimal rating);
}
