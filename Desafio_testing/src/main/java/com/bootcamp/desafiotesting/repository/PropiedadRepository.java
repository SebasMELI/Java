package com.bootcamp.desafiotesting.repository;

import com.bootcamp.desafiotesting.exception.NoSuchBarrioException;
import com.bootcamp.desafiotesting.model.BarrioModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class PropiedadRepository implements IPropiedadRepository{

    private static List<BarrioModel> barrios;

    @Override
    public List<BarrioModel> getBarrios() {
        getListBarrios();
        return barrios;
    }

    @Override
    public BarrioModel getBarrioByName(String name) throws NoSuchBarrioException {
        getListBarrios();
        return barrios.stream().filter(b -> b.getName().equals(name))
                .findFirst().orElseThrow(() -> new NoSuchBarrioException(name));
    }

    private void getListBarrios(){
        if (barrios != null)
            return;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:barrios.json");
            barrios = objectMapper.readValue(file, new TypeReference<List<BarrioModel>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
    }
}
