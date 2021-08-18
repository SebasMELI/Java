package clases;

public class Vehiculo {

    private double velocidad;
    private double aceleracion;
    private double angulodeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAngulodeGiro() {
        return angulodeGiro;
    }

    public void setAngulodeGiro(double angulodeGiro) {
        this.angulodeGiro = angulodeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public void eliminarVehiculo(Vehiculo vehiculo){

    }

    public void eliminarVehiculoConPatente(String unaPatente){

    }
}
