package com.linktrack.service;

import com.linktrack.dtos.ResponseDTO;
import com.linktrack.models.LinkModel;

public interface ILinkTrackerService {

    ResponseDTO createLink(LinkModel linkModel) throws Exception;
    ResponseDTO getLinkPorId(String id, String password) throws Exception;
    ResponseDTO getMetrics(String id) throws Exception;
    ResponseDTO invalidateLink(String id) throws Exception;
    void validateLink(boolean validar) throws Exception;
}
