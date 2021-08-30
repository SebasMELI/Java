package com.meli.obrasliterarias.service;

import com.meli.obrasliterarias.domain.ObrasLiterarias;
import com.meli.obrasliterarias.repository.IObrasLiterariasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObrasLiterariasService implements IObrasLiterariasService {

    private IObrasLiterariasRepository literariasRepository;

    public ObrasLiterariasService(IObrasLiterariasRepository literariasRepository) {
        this.literariasRepository = literariasRepository;
    }

    @Override
    public void saveObrasLiterarias(ObrasLiterarias obrasLiterarias) {
        this.literariasRepository.save(obrasLiterarias);
    }

    @Override
    public List<ObrasLiterarias> getObrasByAuthor(String autor) {
        return this.literariasRepository.findByAutorIs(autor);
    }

    @Override
    public List<ObrasLiterarias> getObrasByNombre(String nombreObra) {
        return this.literariasRepository.findByNombreObraContains(nombreObra);
    }

    @Override
    public List<ObrasLiterarias> getObrasByCantidadPaginas(Integer cantidadPaginas) {
        return this.literariasRepository.findByCantidadPaginasIsGreaterThan(cantidadPaginas);
    }

    @Override
    public List<ObrasLiterarias> getObrasByAnioMayor(Integer anio) {
        return this.literariasRepository.findByAnioIsGreaterThan(anio);
    }

    @Override
    public List<ObrasLiterarias> getObrasByAnioMenor(Integer anio) {
        return this.literariasRepository.findByAnioIsLessThan(anio);
    }

    @Override
    public List<ObrasLiterarias> getObrasByEditorial(String editorial) {
        return this.literariasRepository.findByEditorialIs(editorial);
    }
}
