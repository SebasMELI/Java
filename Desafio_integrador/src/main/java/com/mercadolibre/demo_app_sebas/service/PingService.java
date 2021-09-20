package com.mercadolibre.demo_app_sebas.service;

import com.mercadolibre.demo_app_sebas.dtos.NormalDataDTO;
import com.mercadolibre.demo_app_sebas.repository.InsertarYConsultarRepository;
import org.springframework.stereotype.Service;

@Service
public class PingService {

    private InsertarYConsultarRepository repository;

    public PingService(InsertarYConsultarRepository repository) {
        this.repository = repository;
    }

    public NormalDataDTO insertarYConsultar(NormalDataDTO dto){
        NormalDataDTO dataDTO = repository.save(dto);
        return repository.getOne(dataDTO.getId());
    }

    public NormalDataDTO consultar(Integer id){
        return repository.getOne(id);
    }
}
