package modelos;

public class Invitados {
    private Integer tipoInvitado;
    private String nombreInvitado;

    public Invitados(){
        this.tipoInvitado = 0;
        this.nombreInvitado = "";
    }

    public Invitados(Integer tipoInvitado, String nombreInvitado) {
        this.tipoInvitado = tipoInvitado;
        this.nombreInvitado = nombreInvitado;
    }

    public Integer getTipoInvitado() {
        return tipoInvitado;
    }

    public void setTipoInvitado(Integer tipoInvitado) {
        this.tipoInvitado = tipoInvitado;
    }

    public String getNombreInvitado() {
        return nombreInvitado;
    }

    public void setNombreInvitado(String nombreInvitado) {
        this.nombreInvitado = nombreInvitado;
    }

}
