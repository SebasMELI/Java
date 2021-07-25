package demo;

public class RadixSort
{
    public static int[] radixSort(int []arr)
    {
        String[] arrString = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(arrString, '0');
        StringUtil.sort(arrString, 1);
        StringUtil.sort(arrString, 2);
        StringUtil.sort(arrString, 3);
        StringUtil.sort(arrString, 4);
        StringUtil.sort(arrString, 5);

        return StringUtil.toIntArray(arrString);
    }

    public static void main(String[] args)
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        arr = radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }

    }
}