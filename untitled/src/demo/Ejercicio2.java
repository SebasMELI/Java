package demo;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa numero de veces a multiplicar n: ");
        int n = scanner.nextInt();

        System.out.println("Ingresa valor a obtener multiplos m: ");
        int m = scanner.nextInt();

        scanner.close();

        for (int i=0; i < n; i++) {
            System.out.println(i*m);
        }


    }
}
