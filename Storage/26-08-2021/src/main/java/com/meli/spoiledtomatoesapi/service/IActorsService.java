package com.meli.spoiledtomatoesapi.service;

import com.meli.spoiledtomatoesapi.model.ActorsModel;

import java.math.BigDecimal;
import java.util.List;

public interface IActorsService {
    List<ActorsModel> getActorsByFavoriteMovie();
    List<ActorsModel> getActorsByRating(BigDecimal rating);
}
