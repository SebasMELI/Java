package demo;

import string.utils.StringUtil;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        //CuentaCorriente
        System.out.println("Ejercicio1:\n");

        CuentaCorriente cuentaCorriente = new CuentaCorriente(173532);
        System.out.println(cuentaCorriente.ingreso(23334) + "\n");
        System.out.println(cuentaCorriente.egreso(3455) + "\n");
        System.out.println(cuentaCorriente.reintegro(1222) + "\n");
        System.out.println(cuentaCorriente.transferencia(87373) + "\n\n");

        //Contador
        System.out.println("Ejercicio2:\n");
        Contador contador = new Contador();
        contador.setCuenta(872636.2);
        System.out.println(contador.incremento(72663) + "\n");
        System.out.println(contador.deduccion(6563) + "\n\n");

        //Libro
        System.out.println("Ejercicio3:\n");
        Libro libro = new Libro();
        System.out.println(libro.prestamo() + "\n");
        System.out.println(libro.devolucion() + "\n");
        System.out.println(libro.toString() + "\n\n");

        //Fraccion
        System.out.println("Ejercicio4:\n");
        Fraccion fraccion = new Fraccion(73632,97473);
        System.out.println(fraccion.sumar(2223) + "\n");
        System.out.println(fraccion.resta(726363, 972626.7) + "\n");
        Fraccion fraccion1 = new Fraccion();
        fraccion1.setNumerador(8263);
        fraccion1.setDenominador(87263);
        System.out.println(fraccion.multiplicar(fraccion1) + "\n");
        System.out.println(fraccion.dividir(fraccion1) + "\n\n");

        //Fecha
        System.out.println("Ejercicio5:\n");
        Fecha fecha = new Fecha(new GregorianCalendar());
        System.out.println(fecha.getFecha().getTime() + "\n");
        System.out.println("Fecha " + fecha.verificacionFecha(new GregorianCalendar(2021,7,26)) + "\n");
        System.out.println(fecha.adicionDia().getTime() + "\n\n");

        //StringUtils
        System.out.println("Ejercicio6:\n");
        System.out.println(StringUtil.lpad("5",10,'0') + "\n");
        System.out.println("       Hola");
        System.out.println(StringUtil.ltrim("       Hola") + "\n");
        System.out.println("Hola         ");
        System.out.println(StringUtil.rtrim("Hola         ") + "\n");
        System.out.println("       Hola        ");
        System.out.println(StringUtil.trim("       Hola        ") + "\n");
        System.out.println(StringUtil.indexOfN("John|Paul|George|Ringo",'|',2) + "\n\n");
    }
}
