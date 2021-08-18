package com.codigo.codigomorse.controllers;

import com.codigo.codigomorse.modelos.ResponseMorse;
import com.codigo.codigomorse.utilities.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorse {

    @GetMapping("/getCodigoMorse/{mensaje}")
    public ResponseMorse getCodigoMorse(@PathVariable String mensaje){

        Utilities utilities = new Utilities();
        ResponseMorse responseMorse = new ResponseMorse();
        String letras = utilities.getAlfabeto();
        mensaje = mensaje.toLowerCase();
        String codigo[] = utilities.alfabetoMorse();
        String slash = "/";
        String morse = " ";

        for  (int i = 0; i < mensaje.length() ; i++){
            if (mensaje.charAt(i)==' ') morse = morse+slash+' ';
            else {
                for  (int j = 0; j < letras.length() ; j++) {
                    if (mensaje.charAt(i) == letras.charAt(j))
                        morse = morse + codigo[j]+' ';	// Poner el if si no hay letras
                }
            }
        }

        responseMorse.setMensaje(mensaje);
        responseMorse.setMorse(morse.substring(1,morse.length()));

        return responseMorse;
    }

    @GetMapping("/getStringByMorse/{mensaje}")
    public ResponseMorse getStringByMorse(String mensaje){

        Utilities utilities = new Utilities();
        ResponseMorse responseMorse = new ResponseMorse();
        String letras = utilities.getAlfabeto();
        String morse = " ";
        String codigo[] = utilities.alfabetoMorse();
        String oracion[] = mensaje.split(" ");
        int max = oracion.length;

        for  (int i = 0; i < max; i++){
            for (int j = 0; j < 60; j++)
                if (oracion[i].equals(codigo[j])) {
                    morse = morse+letras.charAt(j);
                    break;
                }
        }

        responseMorse.setMensaje(mensaje);
        responseMorse.setMorse(morse.substring(1,morse.length()));

        return responseMorse;
    }
}
