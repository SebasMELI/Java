package demo;

public class RadixSort
{
    public static String[] radixSort(int []arr)
    {
        String[] arrString = StringUtil.toStringArray(arr);
        StringUtil.sort(arrString, 1, '0');
        StringUtil.sort(arrString, 2, '0');
        StringUtil.sort(arrString, 3, '0');
        StringUtil.sort(arrString, 4, '0');
        StringUtil.sort(arrString, 5, '0');

        return arrString;
    }

    public static void main(String[] args)
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        String[] arrString = radixSort(arr);

        for(int i=0; i<arrString.length;i++)
        {
            System.out.print(arrString[i]+(i<arrString.length-1?",":""));
        }

    }
}