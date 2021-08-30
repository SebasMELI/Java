package com.meli.spoiledtomatoesapi.service.Impl;

import com.meli.spoiledtomatoesapi.model.MiniSerieModel;
import com.meli.spoiledtomatoesapi.repository.IMiniserieRepository;
import com.meli.spoiledtomatoesapi.service.IMiniserieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniSerieService implements IMiniserieService {

    private IMiniserieRepository miniserieRepository;

    public MiniSerieService(IMiniserieRepository miniserieRepository){
        this.miniserieRepository = miniserieRepository;
    }

    @Override
    public MiniSerieModel getMiniSerie(Long id) {
        return this.miniserieRepository.getById(id);
    }

    @Override
    public List<MiniSerieModel> getAllMiniSeries() {
        return this.miniserieRepository.findAll();
    }

    @Override
    public MiniSerieModel createMiniSerie(MiniSerieModel serieModel) {
        return this.miniserieRepository.save(serieModel);
    }

    @Override
    public MiniSerieModel updateMiniSerie(MiniSerieModel serieModel) {
        MiniSerieModel miniSerieModel = this.miniserieRepository.getById(serieModel.getId());
        miniSerieModel.setAwards(serieModel.getAwards());
        miniSerieModel.setName(serieModel.getName());
        miniSerieModel.setRating(serieModel.getRating());
        miniSerieModel.setGenresByGenreId(serieModel.getGenresByGenreId());
        return this.miniserieRepository.save(miniSerieModel);
    }

    @Override
    public void deleteMiniSerie(Long id) {
        this.miniserieRepository.deleteById(id);
    }
}
