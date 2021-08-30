package com.meli.spoiledtomatoesapi.service.Impl;

import com.meli.spoiledtomatoesapi.model.SeriesModel;
import com.meli.spoiledtomatoesapi.repository.ISeriesRepository;
import com.meli.spoiledtomatoesapi.service.ISeriesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService implements ISeriesService {

    private ISeriesRepository seriesRepository;

    public SeriesService(ISeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<SeriesModel> getSeriesByTemps(Long temps) {
        return this.seriesRepository.findBySeasonsModels(temps);
    }
}
