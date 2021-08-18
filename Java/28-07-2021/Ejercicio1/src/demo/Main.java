package demo;

import clases.GuardaRopa;
import clases.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas1 = new ArrayList<>();
        List<Prenda> prendas2 = new ArrayList<>();
        prendas1.add(new Prenda("nike", "123123"));
        prendas1.add(new Prenda("puma", "4356"));
        prendas2.add(new Prenda("adiddas", "3456"));
        prendas2.add(new Prenda("generica", "67678"));
        GuardaRopa guardaRopa = new GuardaRopa();
        Integer lista1 = guardaRopa.guardarPrendas(prendas1);
        System.out.println("Prendas guardadas en la guarda: " + lista1);
        Integer lista2 = guardaRopa.guardarPrendas(prendas2);
        System.out.println("Prendas guardadas en la guarda: " + lista2);
        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(lista2);
        System.out.println("Ahre");
    }
}
