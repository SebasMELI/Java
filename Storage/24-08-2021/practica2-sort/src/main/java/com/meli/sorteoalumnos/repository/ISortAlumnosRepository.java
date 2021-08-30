package com.meli.sorteoalumnos.repository;

import com.meli.sorteoalumnos.models.AlumnosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISortAlumnosRepository extends JpaRepository<AlumnosModel, Long> {
}
