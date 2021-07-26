package demo;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingresa el numero para identificar si es primo:");
        int numero = scanner.nextInt();

        scanner.close();
        if (numeroPrimo(numero)) System.out.println("El numero es primo");
        else System.out.println("El numero no es primo");
    }

    public static boolean numeroPrimo(int numero)
    {
        boolean esPrimo = true;

        int numDivisor=2;

        while((esPrimo) && (numDivisor!=numero)){
            if((numero%numDivisor==0))
                esPrimo=false;
            else
                numDivisor++;

        }

        return esPrimo;
    }
}
