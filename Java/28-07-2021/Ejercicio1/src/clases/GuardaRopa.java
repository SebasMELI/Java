package clases;

import java.util.*;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> prendas;
    private Integer key;

    public GuardaRopa(){
        this.key = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){

        this.key++;
        this.prendas.put(this.key, listaDePrenda);

        return this.key;
    }

    public void mostrarPrendas(){

        for (Map.Entry<Integer, List<Prenda>> prenda:this.prendas.entrySet()) {
            System.out.println("En la guarda: " + prenda.getKey());
            for (Prenda pre: prenda.getValue()) {
                System.out.println("Esta la prenda con marca: " + pre.getMarca() + "con el modelo " + pre.getModelo());
            }

            System.out.println("/---------------/");
        }
    }

    public void devolverPrendas(Integer keyPrenda){

        System.out.println("En la guarda: " + keyPrenda);

        try {
            this.prendas.remove(keyPrenda);
                System.out.println("Prenda Eliminada");
        }catch (Exception ex){
            System.out.println("Guarda no encontrada");
        }

    }
}
