package com.linktrack.repository;

import com.linktrack.dtos.ResponseDTO;
import com.linktrack.models.LinkModel;

public interface ILinkTrackerRepository {
    ResponseDTO createLink(LinkModel linkModel) throws Exception;
    LinkModel getLinkPorId(String id) throws Exception;
    void saveMetrics(LinkModel linkModel) throws Exception;
    LinkModel getMetrics(String id) throws Exception;
    void invalidateLink(String id) throws Exception;
}
