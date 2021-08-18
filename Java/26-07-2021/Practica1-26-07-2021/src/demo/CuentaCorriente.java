package demo;

public class CuentaCorriente {

    private double saldo;

    public CuentaCorriente(){
        this.saldo = 0;
    }

    public CuentaCorriente(int saldo){
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente){
        this.saldo = cuentaCorriente.getSaldo();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double ingreso(double ingresoSaldo){
        return this.saldo += ingresoSaldo;
    }

    public double egreso(double egresoSaldo){
        return this.saldo -= egresoSaldo;
    }

    public double reintegro(double reintegro){
        return this.saldo += reintegro;
    }

    public double transferencia(double saldoTranseferir){
        return this.saldo -= saldoTranseferir;
    }
}
