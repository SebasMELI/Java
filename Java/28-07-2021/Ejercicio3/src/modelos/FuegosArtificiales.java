package modelos;

public class FuegosArtificiales{
    private Integer tipoFuegoArtificial;
    private String ruido;
    private Integer cantidad;

    public FuegosArtificiales() {
    }

    public FuegosArtificiales(Integer tipoFuegoArtificial, String ruido, Integer cantidad) {
        this.tipoFuegoArtificial = tipoFuegoArtificial;
        this.ruido = ruido;
        this.cantidad = cantidad;
    }

    public Integer getTipoFuegoArtificial() {
        return tipoFuegoArtificial;
    }

    public void setTipoFuegoArtificial(Integer tipoFuegoArtificial) {
        this.tipoFuegoArtificial = tipoFuegoArtificial;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getRuido() {
        return ruido;
    }

    public void setRuido(String ruido) {
        this.ruido = ruido;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
