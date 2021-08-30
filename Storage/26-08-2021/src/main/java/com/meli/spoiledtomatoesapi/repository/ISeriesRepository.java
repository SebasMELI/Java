package com.meli.spoiledtomatoesapi.repository;

import com.meli.spoiledtomatoesapi.model.SeriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeriesRepository extends JpaRepository<SeriesModel,Integer> {

    @Query("select s from SeasonsModel sm " +
            "join SeriesModel s on sm.serie.id = s.id " +
            "group by sm.serie " +
            "having count(sm) > :cantidad")
    List<SeriesModel> findBySeasonsModels(@Param("cantidad") Long cantidad);
}
