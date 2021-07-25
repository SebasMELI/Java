package demo;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingresa numero de veces a multiplicar n: ");
        int numero1 = scanner.nextInt();

        System.out.println("Por favor, ingresa valor a obtener multiplos m: ");
        int numero2 = scanner.nextInt();

        for (int i=0; i < numero1; i++) {
            System.out.println(i*numero2);
        }

        scanner.close();
    }
}
