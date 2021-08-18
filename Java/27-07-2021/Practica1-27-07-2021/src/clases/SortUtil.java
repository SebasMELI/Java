package clases;

import interfaceCom.Precedable;

public class SortUtil {
    public static <T extends Precedable> void ordenar(Precedable<T> arr[]){
        for (int j = 0; j < arr.length; j++) {
            for (int i = 1; i < arr.length - j; i++) {
                if (arr[i - 1].precedeA((T)arr[i]) > 0){
                    Precedable aux = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = aux;
                }

            }
        }
    }

    public static <T extends Precedable> void imprimir(Precedable<T> arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString() + "\n");
        }
    }
}
