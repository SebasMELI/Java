package com.meli.sorteoalumnos.service;

import com.meli.sorteoalumnos.models.AlumnosModel;
import com.meli.sorteoalumnos.repository.ISortAlumnosRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortAlumnosService implements ISortAlumnosService {

    private ISortAlumnosRepository sortAlumnosRepository;

    public SortAlumnosService(ISortAlumnosRepository sortAlumnosRepository){
        this.sortAlumnosRepository = sortAlumnosRepository;
    }

    @Override
    public List<AlumnosModel> getSortAlumnos() {
        List<AlumnosModel> alumnosModels = this.sortAlumnosRepository.findAll();
        Collections.shuffle(alumnosModels);
        return alumnosModels.stream().limit(10).collect(Collectors.toList());
    }
}
