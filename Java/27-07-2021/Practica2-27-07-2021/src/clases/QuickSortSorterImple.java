package clases;

import interfaceClass.Sorter;

import java.util.Comparator;

public class QuickSortSorterImple implements Sorter<Integer> {

    private int izq;
    private int der;

    public int getIzq() {
        return izq;
    }

    public void setIzq(int izq) {
        this.izq = izq;
    }

    public int getDer() {
        return der;
    }

    public void setDer(int der) {
        this.der = der;
    }

    @Override
    public void sort(Integer[] arr, Comparator<Integer> c) {
        quickSort(arr, this.izq, this.der);
    }

    private void quickSort(Integer arr[], int izq, int der){
        int pivote=arr[izq];
        int i=izq;
        int j=der;
        int aux;

        while(i < j){
            while(arr[i] <= pivote && i < j) i++;
            while(arr[j] > pivote) j--;
            if (i < j) {
                aux= arr[i];
                arr[i]=arr[j];
                arr[j]=aux;
            }
        }

        arr[izq]=arr[j];
        arr[j]=pivote;

        if(izq < j-1)
            quickSort(arr,izq,j-1);
        if(j+1 < der)
            quickSort(arr,j+1,der);
    }
}
