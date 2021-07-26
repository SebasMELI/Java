package demo;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, escribe un numero:");
        int numero = scanner.nextInt();

        System.out.println("Quedan estos numeros:");
        for (int i = 1; i <= numero; i++) {
            if(i%2==0) {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}
