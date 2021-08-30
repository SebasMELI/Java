package com.meli.spoiledtomatoesapi.service.Impl;

import com.meli.spoiledtomatoesapi.model.ActorsModel;
import com.meli.spoiledtomatoesapi.model.MoviesModel;
import com.meli.spoiledtomatoesapi.repository.IMoviesRepository;
import com.meli.spoiledtomatoesapi.service.IMoviesService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MoviesService implements IMoviesService {

    private IMoviesRepository moviesRepository;

    public MoviesService(IMoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public List<ActorsModel> getActorsByMovieTitle(String name) {
        List<ActorsModel> actorsModels = this.moviesRepository.findByTitleEquals(name);
        actorsModels.stream().forEach(actorsModel -> actorsModel.setFavoriteMovie(null));
        return actorsModels;
    }

    @Override
    public List<MoviesModel> getMoviesByActorsByRating(BigDecimal rating) {
        return this.moviesRepository.findByRatingGreaterThan(rating);
    }

    @Override
    public List<MoviesModel> getMoviesByGenreName(String name) {
        var a = this.moviesRepository.findByGenresModelEquals(name);
        return a;
    }
}
