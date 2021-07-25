package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingresa el numero de numeros primos que deseas visualizar:");
        int numeros = scanner.nextInt();

        System.out.println("Esto tardara un tiempo...");

        List<Integer> numerosPrimos = new ArrayList<>();
        int numero = 1;
        String numerosPrimosConcatenados = "";

        while (numerosPrimos.size() < numeros)
        {
            if(Ejercicio3.numeroPrimo(numero))
                numerosPrimos.add(numero);
            numero++;
        }

        for (int i = 0; i < numerosPrimos.size(); i++) {
            numerosPrimosConcatenados = numerosPrimosConcatenados + numerosPrimos.get(i) + ",";
        }

        System.out.println("Estos son los numeros resultantes:\n { " +
                numerosPrimosConcatenados.substring(0, numerosPrimosConcatenados.length() -1) +
                " }");

        scanner.close();
    }
}
