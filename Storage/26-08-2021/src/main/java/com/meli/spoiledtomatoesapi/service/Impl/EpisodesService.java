package com.meli.spoiledtomatoesapi.service.Impl;

import com.meli.spoiledtomatoesapi.model.EpisodesModel;
import com.meli.spoiledtomatoesapi.repository.IEpisodesRepository;
import com.meli.spoiledtomatoesapi.service.IEpisodesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodesService implements IEpisodesService {

    private IEpisodesRepository episodesRepository;

    public EpisodesService(IEpisodesRepository episodesRepository) {
        this.episodesRepository = episodesRepository;
    }

    @Override
    public List<EpisodesModel> getEpisodesByActor(String nombres, String apellidos) {
        var a = this.episodesRepository.findEpisodesByActors(nombres, apellidos);
        return a;
    }
}
