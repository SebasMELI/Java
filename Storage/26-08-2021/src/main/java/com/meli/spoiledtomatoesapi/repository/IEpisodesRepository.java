package com.meli.spoiledtomatoesapi.repository;

import com.meli.spoiledtomatoesapi.model.EpisodesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodesRepository extends JpaRepository<EpisodesModel,Integer> {

    @Query("select e from EpisodesModel e " +
            "join ActorEpisodeModel ae on e.id = ae.episodesModel.id " +
            "join ActorsModel a on ae.actors.id = a.id " +
            "where a.firstName = :nombres and a.lastName = :apellidos")
    List<EpisodesModel> findEpisodesByActors(@Param("nombres") String nombres, @Param("apellidos") String apellidos);
}
