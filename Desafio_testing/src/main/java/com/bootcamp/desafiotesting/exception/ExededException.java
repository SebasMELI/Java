package com.bootcamp.desafiotesting.exception;

public class ExededException extends Exception{
    public ExededException(String barrio) {
        super( barrio + " exede el tamaño del terreno.");
    }
}
