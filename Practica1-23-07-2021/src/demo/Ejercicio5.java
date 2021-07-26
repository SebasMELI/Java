package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingresa la cantidad de numeros a retornar:");
        int numeroN = scanner.nextInt();
        System.out.println("Por favor, ingresa la cantidad de digitos que debe contener:");
        int numeroM = scanner.nextInt();
        System.out.println("Por favor, ingresa el digito que se debe repetir:");
        int numeroD = scanner.nextInt();

        System.out.println("Esto tardara un tiempo...");

        List<Integer> numeros = new ArrayList<>();
        int numero = 0;
        String numeroWhile = "";
        String numerosConcatenados = "";

        while(numeros.size() < numeroN)
        {
            numeroWhile = Integer.toString(numero);
            char numeroCharArray[] = numeroWhile.toCharArray();
            int digitosContenidos = 0;

            for (int i = 0; i < numeroCharArray.length; i++)
                if (Character.getNumericValue(numeroCharArray[i]) == numeroD)
                    digitosContenidos++;

            if (digitosContenidos >= numeroM) numeros.add(numero);

            numero++;
        }

        for (int i = 0; i < numeros.size(); i++) {
            numerosConcatenados = numerosConcatenados + numeros.get(i) + ",";
        }

        System.out.println("Estos son los numeros resultantes:\n { " +
                numerosConcatenados.substring(0, numerosConcatenados.length() -1) +
                " }");

        scanner.close();
    }
}
