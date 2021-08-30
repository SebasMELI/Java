package com.meli.spoiledtomatoesapi.service;

import com.meli.spoiledtomatoesapi.model.SeriesModel;

import java.util.List;

public interface ISeriesService {

    List<SeriesModel> getSeriesByTemps(Long temps);
}
