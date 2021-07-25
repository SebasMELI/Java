package demo;

import java.util.ArrayList;
import java.util.List;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String caracteres = "";
        for (int i = 0; i < n; i++)
            caracteres += c;
        return caracteres;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        String caracteres = "";
        for (int i = 0; i < n - 1; i++)
            if ((caracteres + s).length() < n)
                caracteres += c;
        return caracteres += s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        int arrLength = arr.length;
        String[] caracteres = new String[arrLength];
        for (int i = 0; i < arrLength; i++) {
            caracteres[i] = Integer.toString(arr[i]);
        }
        return caracteres;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int arrLength = arr.length;
        int[] caracteres = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            caracteres[i] = Integer.parseInt(arr[i]);
        }
        return caracteres;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int longitud = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i].length() > longitud) longitud = arr[i].length();
        return longitud;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int longitud = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], longitud, c);
        }
    }


    public static String[] sort(String[] arrString, int sort, char cSort)
    {
        List<String> numeros = new ArrayList<>();
        StringUtil.lNormalize(arrString, cSort);
        int arrStringLength = arrString.length;

        List<String> lista0 = new ArrayList<>();
        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();
        List<String> lista3 = new ArrayList<>();
        List<String> lista4 = new ArrayList<>();
        List<String> lista5 = new ArrayList<>();
        List<String> lista6 = new ArrayList<>();
        List<String> lista7 = new ArrayList<>();
        List<String> lista8 = new ArrayList<>();
        List<String> lista9 = new ArrayList<>();

        for (int i = 0; i < arrStringLength; i++) {

            switch(arrString[i].substring(arrString[i].length() - sort).substring(0,1)) {
                case "0": lista0.add(arrString[i]); break;
                case "1": lista1.add(arrString[i]); break;
                case "2": lista2.add(arrString[i]); break;
                case "3": lista3.add(arrString[i]); break;
                case "4": lista4.add(arrString[i]); break;
                case "5": lista5.add(arrString[i]); break;
                case "6": lista6.add(arrString[i]); break;
                case "7": lista7.add(arrString[i]); break;
                case "8": lista8.add(arrString[i]); break;
                case "9": lista9.add(arrString[i]); break;

            }
        }

        for (String lista:lista0) numeros.add(lista);
        for (String lista:lista1) numeros.add(lista);
        for (String lista:lista2) numeros.add(lista);
        for (String lista:lista3) numeros.add(lista);
        for (String lista:lista4) numeros.add(lista);
        for (String lista:lista5) numeros.add(lista);
        for (String lista:lista6) numeros.add(lista);
        for (String lista:lista7) numeros.add(lista);
        for (String lista:lista8) numeros.add(lista);
        for (String lista:lista9) numeros.add(lista);

        for (int i = 0; i < arrStringLength; i++)
            arrString[i] = numeros.get(i);

        return  arrString;
    }

}