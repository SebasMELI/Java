package com.meli.spoiledtomatoesapi.service;

import com.meli.spoiledtomatoesapi.model.MiniSerieModel;

import java.util.List;

public interface IMiniserieService {
    MiniSerieModel getMiniSerie(Long id);
    List<MiniSerieModel> getAllMiniSeries();
    MiniSerieModel createMiniSerie(MiniSerieModel serieModel);
    MiniSerieModel updateMiniSerie(MiniSerieModel serieModel);
    void deleteMiniSerie(Long id);
}
