package com.meli.spoiledtomatoesapi.repository;

import com.meli.spoiledtomatoesapi.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
