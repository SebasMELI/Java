package com.bootcamp.desafiotesting.service;

import com.bootcamp.desafiotesting.dtos.CuartoDTO;
import com.bootcamp.desafiotesting.dtos.PropiedadRequestDTO;
import com.bootcamp.desafiotesting.exception.ExededException;
import com.bootcamp.desafiotesting.exception.NoSuchBarrioException;
import com.bootcamp.desafiotesting.model.BarrioModel;
import com.bootcamp.desafiotesting.model.CuartoModel;
import com.bootcamp.desafiotesting.model.PropiedadModel;
import com.bootcamp.desafiotesting.repository.IPropiedadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropiedadService implements IPropiedadService{

    private IPropiedadRepository propiedadRepository;

    public PropiedadService(IPropiedadRepository propiedadRepository){
        this.propiedadRepository = propiedadRepository;
    }

    @Override
    public PropiedadModel totalMetrosCuadradosPropiedad(PropiedadRequestDTO request){
        PropiedadModel response = new PropiedadModel();
        response.setProp_name(request.getProp_name());
        Double totalAncho = 0.0;
        Double totalLargo = 0.0;

        for (CuartoDTO habitacion: request.getRooms()) {
            totalAncho += habitacion.getRoom_width();
            totalLargo += habitacion.getRoom_length();
        }

        response.setProp_total_prop(totalAncho * totalLargo);
        return response;
    }

    @Override
    public PropiedadModel totalSuperficieSinConstruccion(PropiedadRequestDTO request) throws NoSuchBarrioException, ExededException {
        PropiedadModel response = new PropiedadModel();
        response.setProp_name(request.getProp_name());
        Double areaBarrio = propiedadRepository.getBarrioByName(request.getDistrict_name()).getArea();
        Double areaRestante = areaBarrio - totalMetrosCuadradosPropiedad(request).getProp_total_prop();

        if (areaRestante < 0)
            throw new ExededException(request.getProp_name());

        response.setTerreno_faltante(areaRestante);
        return response;
    }

    @Override
    public PropiedadModel precioPropiedad(PropiedadRequestDTO request) throws NoSuchBarrioException {
        PropiedadModel response = new PropiedadModel();
        response.setProp_name(request.getProp_name());
        response.setPrecio_terreno(
                request.getDistrict_built_price() * totalMetrosCuadradosPropiedad(request).getProp_total_prop()
        );
        return response;
    }

    @Override
    public CuartoModel cuartoMasGrande(PropiedadRequestDTO request){
        CuartoModel response = new CuartoModel();
        Double total = 0.0;

        for (CuartoDTO habitacion: request.getRooms()) {
            if ((habitacion.getRoom_width() * habitacion.getRoom_length()) > total){
                total = habitacion.getRoom_width() * habitacion.getRoom_length();
                response = new ModelMapper().map(habitacion ,CuartoModel.class);
            }
        }

        return response;
    }

    @Override
    public List<CuartoModel> metrosPorCuarto(PropiedadRequestDTO request){
        List<CuartoModel> dtoList = new ArrayList<>();

        for (CuartoDTO cuarto: request.getRooms()) {
            CuartoModel cuartoModel = new CuartoModel();
            cuartoModel.setRoom_name(cuarto.getRoom_name());
            cuartoModel.setRoom_width(cuarto.getRoom_width());
            cuartoModel.setRoom_length(cuarto.getRoom_length());
            cuartoModel.setCantidad_metros_cuadrados(cuarto.getRoom_width() * cuarto.getRoom_length());
            dtoList.add(cuartoModel);
        }
        return dtoList;
    }

    @Override
    public List<BarrioModel> getBarrios() {
        return propiedadRepository.getBarrios();
    }

    @Override
    public BarrioModel getBarrioPorNombre(String name) throws NoSuchBarrioException {
        return propiedadRepository.getBarrioByName(name);
    }
}
