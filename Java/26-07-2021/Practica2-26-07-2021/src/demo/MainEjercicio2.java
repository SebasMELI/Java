package demo;

import geometria.Circulo;
import geometria.FiguraGeometrica;
import geometria.Rectangulo;
import geometria.Triangulo;
import utilitario.Utilitario;

public class MainEjercicio2 {

    public static void main(String[] args) {

        FiguraGeometrica[] arr = new FiguraGeometrica[3];
        arr[0] = new Circulo(123);
        arr[1] = new Rectangulo(345,983);
        arr[2] = new Triangulo(234,766);

        System.out.println("Area promedio: " + Utilitario.areaPromedio(arr));
    }
}
