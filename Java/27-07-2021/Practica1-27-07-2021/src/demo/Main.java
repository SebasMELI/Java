package demo;

import clases.Celular;
import clases.Persona;
import clases.SortUtil;

public class Main {
    public static void main(String[] args) {

        //Persona
        Persona[] persona = new Persona[5];
        persona[0] = new Persona("nombre1", 234234);
        persona[1] = new Persona("nombre3", 455443);
        persona[2] = new Persona("nombre5", 123334);
        persona[3] = new Persona("nombre2", 237765);
        persona[4] = new Persona("nombre4", 237898);

        SortUtil.imprimir(persona);
        SortUtil.ordenar(persona);
        SortUtil.imprimir(persona);

        //Celular
        Celular[] celular = new Celular[5];
        celular[0] = new Celular(762535322, "titular6");
        celular[1] = new Celular(992836364, "titular9");
        celular[2] = new Celular(872535322, "titular3");
        celular[3] = new Celular(778126379, "titular2");
        celular[4] = new Celular(553737323, "titular5");

        SortUtil.imprimir(celular);
        SortUtil.ordenar(celular);
        SortUtil.imprimir(celular);

    }
}
