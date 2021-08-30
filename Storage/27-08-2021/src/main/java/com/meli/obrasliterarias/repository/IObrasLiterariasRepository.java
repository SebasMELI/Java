package com.meli.obrasliterarias.repository;

import com.meli.obrasliterarias.domain.ObrasLiterarias;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObrasLiterariasRepository extends ElasticsearchRepository<ObrasLiterarias, Integer> {
    List<ObrasLiterarias> findByAutorIs(String autor);
    List<ObrasLiterarias> findByNombreObraContains(String nombreObra);
    List<ObrasLiterarias> findByCantidadPaginasIsGreaterThan(Integer cantidadPaginas);
    List<ObrasLiterarias> findByAnioIsGreaterThan(Integer anio);
    List<ObrasLiterarias> findByAnioIsLessThan(Integer anio);
    List<ObrasLiterarias> findByEditorialIs(String editorial);
}
