package demo;

import clases.BubbleSortSorterImple;
import clases.HeapSortSorterImple;
import clases.QuickSortSorterImple;
import clases.Time;

public class Main {

    public static void main(String[] args) {
        MyFactory myFactory = new MyFactory();
        String[] arrString = new String[6];
        Integer[] arrInt = new Integer[6];
        Integer[] arrIntSortQuick = new Integer[100000];
        String[] arrStringSort = new String[100000];
        Integer[] arrIntSortHeap = new Integer[100000];

        try {
            Object sorterInt = Class.forName(myFactory.getInstance("sorterInt").toString()).newInstance();
            Object sorterString = Class.forName(myFactory.getInstance("sorterString").toString()).newInstance();
            Object sorterIntHeapSort = Class.forName(myFactory.getInstance("sorterIntHeapSort").toString()).newInstance();

            arrString[0] = "Zile";
            arrString[1] = "Parque";
            arrString[2] = "Xilofono";
            arrString[3] = "Normit";
            arrString[4] = "Anabel";
            arrString[5] = "Casa";

            arrInt[0] = 23423;
            arrInt[1] = 98723;
            arrInt[2] = 12332;
            arrInt[3] = 72364;
            arrInt[4] = 23444;
            arrInt[5] = 66525;

            BubbleSortSorterImple bubbleSort = (BubbleSortSorterImple)sorterString;
            //bubbleSort.sort(arrString, (a,b)->b.compareTo(a));

            QuickSortSorterImple quickSort = (QuickSortSorterImple)sorterInt;
            quickSort.setDer(5);
            quickSort.setIzq(0);
            //quickSort.sort(arrInt, (h,r)->h-r);

            HeapSortSorterImple heapSort = (HeapSortSorterImple)sorterIntHeapSort;
            //heapSort.sort(arrInt, (v,n)->v-n);

            printArray(arrString);
            printArray(arrInt);

            Thread.sleep(1000);

            System.out.println("Inicio del timer");

            Time time = new Time();

            for (int i = 0; i < 100000; i++) {
                arrIntSortQuick[i] = i;
                arrStringSort[i] = Integer.toString(i);
                arrIntSortHeap[i] = i;
            }

            time.start();
            bubbleSort.sort(arrStringSort, (a,b)->b.compareTo(a));
            time.stop();

            System.out.println("El tiempo transcurrido de BubbleSort en milisegundos es " + time.elapsedTime());

            time.start();
            quickSort.sort(arrIntSortQuick, (h,r)->h-r);
            time.stop();

            System.out.println("El tiempo transcurrido de QuickSort en milisegundos es " + time.elapsedTime());

            time.start();
            heapSort.sort(arrIntSortHeap, (v,n)->v-n);
            time.stop();

            System.out.println("El tiempo transcurrido de HeapSort en milisegundos es " + time.elapsedTime());


        }catch (Exception ex){
            System.out.println(ex.fillInStackTrace());
        }

    }

    private static <T> void printArray(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("/----------------------------/");
    }

}
