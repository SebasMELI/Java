package interfaces;

import modelos.FuegosArtificiales;

import java.util.List;

public interface IFuegoArtificial {

    public List<FuegosArtificiales> prepararFuegosArtificiales();
    public void explotar(List<FuegosArtificiales> fuegosArtificiales);
}
