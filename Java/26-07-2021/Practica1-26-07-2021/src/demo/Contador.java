package demo;

public class Contador {
    private double cuenta;

    public Contador()
    {
        this.cuenta = 0;
    }

    public Contador(int cuenta)
    {
        this.cuenta = cuenta;
    }

    public Contador(Contador contador)
    {
        this.cuenta = contador.getCuenta();
    }

    public double getCuenta() {
        return cuenta;
    }

    public void setCuenta(double valor) {
        this.cuenta = valor;
    }

    public double incremento(double valor)
    {
        return this.cuenta + valor;
    }

    public double deduccion(double valor)
    {
        return this.cuenta - valor;
    }

}
