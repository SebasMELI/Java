package com.meli.spoiledtomatoesapi.service;

import com.meli.spoiledtomatoesapi.model.EpisodesModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodesService {
    List<EpisodesModel> getEpisodesByActor(String nombres, String apellidos);
}
