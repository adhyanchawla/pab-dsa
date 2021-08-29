import java.util.*;

public class quickSelect {
    
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int []arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        System.out.println(quickselect(arr, k));
        //System.out.println(arr[arr.length-1-k]);
    }


    public static int partition(int []arr, int pIdx, int lo, int hi)
    {
        swap(arr, pIdx, hi);
        int p  = lo - 1;
        int itr = lo;

        while(itr <= hi)
        {
            if(arr[itr] <= arr[hi])
            swap(arr, itr, ++p);

            itr++;
        }

        return p;

    }

    public static void quickselect(int []arr, int lo, int hi, int k)
    {
        if(lo > hi)
        {
            return;
        }

        int pivotIdx = hi;
        int part = partition(arr, pivotIdx,lo, hi);
        if(part == k)
        return;
        else if(k > part)
        quickselect(arr, part + 1, hi, k);
        else
        quickselect(arr, lo, part-1, k);
    }

    public static void swap(int[]arr, int lo, int hi)
    {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }


    public static int quickselect(int[]arr, int k)
    {
        int n = arr.length;
        int idx = n-k;
        quickselect(arr, 0, n-1, idx);

        return arr[idx];
    }


}
