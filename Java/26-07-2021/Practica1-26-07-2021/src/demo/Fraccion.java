package demo;

public class Fraccion {

    private double numerador;
    private double denominador;

    public Fraccion(){
        this.numerador = 0;
        this.denominador = 0;
    }

    public Fraccion(double numerador, double denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public double sumar(Fraccion fraccion){

        if (this.denominador == fraccion.getDenominador())
        {
            return (this.numerador + fraccion.getNumerador()) / this.denominador;
        }else{
            return (this.numerador + fraccion.getNumerador()) / (this.denominador * fraccion.getDenominador());
        }
    }

    public double sumar(double numero){

        return (this.numerador + numero) / this.denominador;
    }

    public double sumar(double numero1, double numero2){

        return numero1 + numero2;
    }

    public double resta(Fraccion fraccion){

        if (this.denominador == this.denominador)
        {
            return (this.numerador - fraccion.getNumerador()) / this.denominador;
        }else{
            return (this.numerador - fraccion.getNumerador()) / (this.denominador * fraccion.getDenominador());
        }
    }

    public double resta(double numero){

        return (this.numerador - numero) / this.denominador;
    }

    public double resta(double numero1, double numero2){

        return numero1 + numero2;
    }

    public double multiplicar(Fraccion fraccion){

        return (this.numerador * fraccion.getNumerador()) / (this.denominador * fraccion.getDenominador());
    }

    public double multiplicar(double numero){

        return (this.numerador * numero) / this.denominador;
    }

    public double multiplicar(double numero1, double numero2){

        return numero1 * numero2;
    }

    public double dividir(Fraccion fraccion){

        return (this.numerador * fraccion.getDenominador()) / (this.denominador * fraccion.getNumerador());
    }

    public double dividir(double numero){

        return (numero * this.denominador) / this.denominador;
    }

    public double dividir(double numero1, double numero2){

        return numero1 / numero2;
    }

    public double getNumerador() {
        return numerador;
    }

    public void setNumerador(double numerador) {
        this.numerador = numerador;
    }

    public double getDenominador() {
        return denominador;
    }

    public void setDenominador(double denominador) {
        this.denominador = denominador;
    }

}
