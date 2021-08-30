package com.meli.spoiledtomatoesapi.service.Impl;

import com.meli.spoiledtomatoesapi.model.ActorsModel;
import com.meli.spoiledtomatoesapi.repository.IActorsRepository;
import com.meli.spoiledtomatoesapi.service.IActorsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ActorsService implements IActorsService {

    private IActorsRepository actorsRepository;

    public ActorsService(IActorsRepository actorsRepository){
        this.actorsRepository = actorsRepository;
    }

    @Override
    public List<ActorsModel> getActorsByFavoriteMovie() {
        return this.actorsRepository.findByFavoriteMovieId();
    }

    @Override
    public List<ActorsModel> getActorsByRating(BigDecimal rating) {
        return this.actorsRepository.findByRatingGreaterThan(rating);
    }

}
