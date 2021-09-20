package com.mercadolibre.demo_app_sebas.repository;

import com.mercadolibre.demo_app_sebas.dtos.NormalDataDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertarYConsultarRepository extends JpaRepository<NormalDataDTO, Integer> {
}
