package demo;

import modelos.FuegosArtificiales;
import clases.Invitado;
import modelos.Invitados;
import clases.PackFuegosArtificiales;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Invitado invitado = new Invitado();
        PackFuegosArtificiales packFuegosArtificiales = new PackFuegosArtificiales();
        List<Invitados> listInvitados = new ArrayList<>();
        System.out.println("Marte Group S.A");
        //Invitados 1-MELI 2-Standard
        System.out.println("¿Cuantos invitados hay?");
        int invitados = scanner.nextInt();

        for (int i = 0; i < invitados; i++) {
            Invitados invi = new Invitados();
            System.out.println("Esciba el tipo de invitado 1-MELI 2-Standard:");
            int tipoInvitado = scanner.nextInt();
            invi.setTipoInvitado(tipoInvitado);

            System.out.println("Esciba el nombre del invitado:");
            String invitadoNombre = scanner.next();
            invi.setNombreInvitado(invitadoNombre);

            listInvitados.add(invi);
        }

        System.out.println("Todos los invitados llegaron!");

        invitado.comerTorta();

        System.out.println("Preparando fuegos artificiales...");

        //1-Individual 2-Pack
        List<FuegosArtificiales> fuegosArtificiales = packFuegosArtificiales.prepararFuegosArtificiales();

        System.out.println("3");
        Thread.sleep(3000);
        System.out.println("2");
        Thread.sleep(2000);
        System.out.println("1");
        Thread.sleep(1000);

        invitado.gritar(listInvitados);

        Thread.sleep(1000);

        packFuegosArtificiales.explotar(fuegosArtificiales);

    }
}
