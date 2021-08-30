package com.meli.obrasliterarias.service;

import com.meli.obrasliterarias.domain.ObrasLiterarias;

import java.util.List;

public interface IObrasLiterariasService {

    void saveObrasLiterarias(ObrasLiterarias obrasLiterarias);
    List<ObrasLiterarias> getObrasByAuthor(String autor);
    List<ObrasLiterarias> getObrasByNombre(String nombreObra);
    List<ObrasLiterarias> getObrasByCantidadPaginas(Integer cantidadPaginas);
    List<ObrasLiterarias> getObrasByAnioMayor(Integer anio);
    List<ObrasLiterarias> getObrasByAnioMenor(Integer anio);
    List<ObrasLiterarias> getObrasByEditorial(String editorial);
}
