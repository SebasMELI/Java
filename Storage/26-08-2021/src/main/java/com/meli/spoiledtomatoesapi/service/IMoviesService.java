package com.meli.spoiledtomatoesapi.service;

import com.meli.spoiledtomatoesapi.model.ActorsModel;
import com.meli.spoiledtomatoesapi.model.MoviesModel;

import java.math.BigDecimal;
import java.util.List;

public interface IMoviesService {
    List<ActorsModel> getActorsByMovieTitle(String name);
    List<MoviesModel> getMoviesByActorsByRating(BigDecimal rating);
    List<MoviesModel> getMoviesByGenreName(String name);
}
