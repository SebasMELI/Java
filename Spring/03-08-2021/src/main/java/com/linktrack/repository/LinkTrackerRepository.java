package com.linktrack.repository;

import com.linktrack.dtos.ResponseDTO;
import com.linktrack.models.LinkModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {

    private static List<LinkModel> lstLink = new ArrayList<>();

    @Override
    public ResponseDTO createLink(LinkModel linkModel) throws Exception {
        ResponseDTO response = new ResponseDTO();
        linkModel.setIdLink(UUID.randomUUID().toString());
        this.lstLink.add(linkModel);
        response.setIdLink(linkModel.getIdLink());
        return response;
    }

    @Override
    public LinkModel getLinkPorId(String id) throws Exception {
        return this.lstLink.stream()
                .filter(link -> link.getIdLink().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("No se encontro la url"));
    }

    @Override
    public void saveMetrics(LinkModel linkModel) throws Exception {
        LinkModel link = getLinkPorId(linkModel.getIdLink());
        this.lstLink.remove(link);
        link.setMetrics(link.getMetrics() + 1);
        this.lstLink.add(link);
    }

    @Override
    public LinkModel getMetrics(String id) throws Exception {
        return getLinkPorId(id);
    }

    @Override
    public void invalidateLink(String id) throws Exception {
        LinkModel link = getLinkPorId(id);
        this.lstLink.remove(link);
        link.setMetrics(link.getMetrics() + 1);
        this.lstLink.add(link);
    }
}
