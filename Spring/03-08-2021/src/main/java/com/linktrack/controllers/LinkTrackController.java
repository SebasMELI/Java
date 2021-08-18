package com.linktrack.controllers;

import com.linktrack.models.LinkModel;
import com.linktrack.dtos.ResponseDTO;
import com.linktrack.service.LinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkTrackController {

    private LinkTrackerService linkTrackerService;

    public LinkTrackController(){
        this.linkTrackerService = new LinkTrackerService();
    }

    @PostMapping("/crearLink")
    public ResponseEntity<ResponseDTO> crearLink(@RequestBody LinkModel linkmodel) throws Exception {
        return new ResponseEntity(this.linkTrackerService.createLink(linkmodel), HttpStatus.OK);
    }

    @GetMapping("/getLinkPorId/{idLink}/{password}")
    public ResponseEntity<Void> getLinkPorId(@PathVariable String idLink, @PathVariable String password) throws Exception {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(this.linkTrackerService.getLinkPorId(idLink, password).getLink()))
                .build();
    }

    @GetMapping("/getMetrics/{idLink}")
    public ResponseEntity<ResponseDTO> getMetrics(@PathVariable String idLink) throws Exception {
        return new ResponseEntity(this.linkTrackerService.getMetrics(idLink), HttpStatus.OK);
    }

    @PostMapping("/invalidateLink/{idLink}")
    public ResponseEntity<ResponseDTO>invalidateLink(@PathVariable String idLink) throws Exception{
        return new ResponseEntity(this.linkTrackerService.invalidateLink(idLink), HttpStatus.OK);
    }

}
