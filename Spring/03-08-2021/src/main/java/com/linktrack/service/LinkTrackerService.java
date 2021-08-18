package com.linktrack.service;

import com.linktrack.models.LinkModel;
import com.linktrack.dtos.ResponseDTO;
import com.linktrack.repository.LinkTrackerRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerService implements ILinkTrackerService{

    private LinkTrackerRepository linkTrackerRepository;
    private static String password;

    public LinkTrackerService(){
        this.linkTrackerRepository = new LinkTrackerRepository();
    }

    @Override
    public ResponseDTO createLink(LinkModel linkModel) throws Exception {
        ResponseDTO response = this.linkTrackerRepository.createLink(linkModel);
        response.setMessage("Link guardado");
        this.password = linkModel.getPassword();
        return response;
    }

    @Override
    public ResponseDTO getLinkPorId(String id, String password) throws Exception {
        if(!this.password.equals(password))
            throw new Exception("Contraseña no valida");
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Link encontrado");
        LinkModel linkModel = this.linkTrackerRepository.getLinkPorId(id);
        validateLink(linkModel.isValidate());
        this.linkTrackerRepository.saveMetrics(linkModel);
        response.setLink(linkModel.getLink());
        return response;
    }

    @Override
    public ResponseDTO getMetrics(String id) throws Exception {
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Link encontrado");
        LinkModel linkModel = this.linkTrackerRepository.getMetrics(id);
        validateLink(linkModel.isValidate());
        response.setLink(linkModel.getLink());
        response.setMetrics(linkModel.getMetrics());
        return response;
    }

    @Override
    public ResponseDTO invalidateLink(String id) throws Exception {
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Link invalidado");
        this.linkTrackerRepository.invalidateLink(id);
        return response;
    }

    @Override
    public void validateLink(boolean validar) throws Exception {
        if(!validar)
            throw new Exception("Link no habilitado");
    }

}
