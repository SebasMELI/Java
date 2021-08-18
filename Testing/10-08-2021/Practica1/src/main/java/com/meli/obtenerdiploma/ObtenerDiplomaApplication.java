package com.meli.obtenerdiploma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObtenerDiplomaApplication {

	public static void main(String[] args) {
		//@NotBlank : Comprueba que la secuencia de caracteres anotada no sea nula y que la longitud recortada sea mayor que 0.
		//@NotNull : Comprueba si el elemento anotado no es nulo ni está vacío.
		//@NotEmpty : Comprueba que el valor anotado no sea nulo
		SpringApplication.run(ObtenerDiplomaApplication.class, args);
	}

}
