package com.practica2.contollers;

import com.practica2.dtos.ResponsePersonajeDTO;
import com.practica2.service.StarWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarWarsController {

    private StarWarsService starWarsService;

    public StarWarsController(){

        this.starWarsService = new StarWarsService();
    }

    @GetMapping("/getPersonajesPorNombre/{nombre}")
    public ResponseEntity<?> getStarWarsPorNombre(@PathVariable String nombre){

        try{
            return new ResponseEntity(this.starWarsService.getPersonaje(nombre), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity(new ResponsePersonajeDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
