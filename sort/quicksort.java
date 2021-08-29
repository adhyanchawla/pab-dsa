import java.util.*;

public class quicksort{

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }

        quicksortArray(arr, 0, arr.length-1);

        for(int ele : arr)
        {
            System.out.print(ele + " ");
        }

    }

    public static int partition(int[] arr, int pivot, int lo, int hi)
    {
        swap(arr, pivot, hi);
        int p = lo-1;
        int itr = lo;
        while(itr <= hi)
        {
            if(arr[itr] <= arr[hi])
            {
                swap(arr, itr, ++p);
            }
            itr++;
        }
        
        //swap(arr, ++p, hi);

        return p;
    }
    // kitne region ko sort krna hai
    public static void quicksortArray(int []arr, int lo, int hi)
    {
        if(lo > hi)
        return;

        //faith pivot ko sahi jagah pe rakh rha hu
        //mere left wale sort ho kar aa jayenge
        //mere right wale sort ho kar aa jayenge
        // random.nextInt(ei-si) + si; //range ke andr answer
        //int pivot = (int) ((Math.random() * (max - min) + min);
        int pivot = hi;
        int part = partition(arr, pivot, lo, hi);

        quicksortArray(arr, lo, part-1);
        quicksortArray(arr, part+1, hi);
    }

    public static void swap(int[]arr, int lo, int hi)
    {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
}