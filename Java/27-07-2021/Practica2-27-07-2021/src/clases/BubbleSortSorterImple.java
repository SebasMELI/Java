package clases;

import interfaceClass.BubbleSort;

import java.util.Comparator;

public class BubbleSortSorterImple implements BubbleSort<String> {

    @Override
    public void sort(String[] arr, Comparator<String> c) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (c.compare(arr[j], arr[j+1]) < 0)
                {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}
