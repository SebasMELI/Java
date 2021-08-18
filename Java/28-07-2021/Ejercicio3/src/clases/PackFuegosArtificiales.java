package clases;

import interfaces.IFuegoArtificial;
import modelos.FuegosArtificiales;

import java.util.ArrayList;
import java.util.List;

public class PackFuegosArtificiales implements IFuegoArtificial {

    @Override
    public void explotar(List<FuegosArtificiales> fuegosArtificiales) {

        try
        {

            for (FuegosArtificiales fuegoArtificial: fuegosArtificiales) {
                if(fuegoArtificial.getTipoFuegoArtificial() == 2) {
                    for (int i = 0; i < fuegoArtificial.getCantidad(); i++) {
                        System.out.println(fuegoArtificial.getRuido());
                        Thread.sleep(400);
                    }
                }
                else {
                    System.out.println(fuegoArtificial.getRuido());
                    Thread.sleep(400);
                }
            }
        }catch(Exception ex){
            System.out.println("Error en tiempo de ejecucion");
        }

    }

    @Override
    public List<FuegosArtificiales>  prepararFuegosArtificiales() {

        List<FuegosArtificiales> fuegosArtificiales = new ArrayList();

        try{

            Thread.sleep(3000);

            fuegosArtificiales.add(new FuegosArtificiales(1, "Huraaaa!!!!!", 1));
            fuegosArtificiales.add(new FuegosArtificiales(2, "Huriiiiaaaa!!!!!", 10));
            fuegosArtificiales.add(new FuegosArtificiales(1, "Ahreeee!!!!!", 1));
            fuegosArtificiales.add(new FuegosArtificiales(2, "Boaaaaaaaa!!!!!", 15));
            fuegosArtificiales.add(new FuegosArtificiales(2, "Wuaaaaaaaa!!!!!", 20));

            System.out.println("Fuegos artificiales preparados!!");
        }
        catch(Exception ex){
            System.out.println("Error en tiempo de ejecucion");
        }

        return fuegosArtificiales;
    }
}
