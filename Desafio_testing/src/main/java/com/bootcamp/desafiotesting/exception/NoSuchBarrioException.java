package com.bootcamp.desafiotesting.exception;

public class NoSuchBarrioException extends Exception{

    public NoSuchBarrioException(String barrio) {
        super( barrio + " no ha sido encontrado.");
    }

}
