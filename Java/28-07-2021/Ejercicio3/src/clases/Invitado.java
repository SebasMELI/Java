package clases;

import interfaces.IInvitado;
import modelos.Invitados;

import java.util.List;

public class Invitado implements IInvitado {

    @Override
    public void gritar(List<Invitados> invitados){
        for (Invitados invitado: invitados) {
            if (invitado.getTipoInvitado().equals(1))
                System.out.println(invitado.getNombreInvitado() + " grita !Viva La Chiqui¡" );
        }
    }

    @Override
    public void comerTorta() {
        try{
            Thread.sleep(1000);
            System.out.println("Comiendo torta...");
            Thread.sleep(7000);
        }catch (Exception ex){
            System.out.println("Error en tiempo de ejecucion");
        }
    }
}
