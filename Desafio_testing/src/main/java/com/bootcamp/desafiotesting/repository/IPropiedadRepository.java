package com.bootcamp.desafiotesting.repository;

import com.bootcamp.desafiotesting.exception.NoSuchBarrioException;
import com.bootcamp.desafiotesting.model.BarrioModel;

import java.util.List;

public interface IPropiedadRepository {
    public List<BarrioModel> getBarrios();
    public BarrioModel getBarrioByName(String name) throws NoSuchBarrioException;
}
