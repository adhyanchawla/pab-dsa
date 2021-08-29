import java.util.*;

public class searchsort{

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int pivotIdx = 3;

        //int ans = partition(arr, data);
        //System.out.println(ans);
        int ans = partitionWithPivotIdx(arr, pivotIdx);
        System.out.println(ans);
        for(int ele : arr)
        {
            System.out.print(ele + " ");
        }
    }

    public static void bubbleSort(int []arr)
    {
        int n = arr.length;

        for(int li = n-1; li > 0; li--)
        {
            for(int i = 1; i <= li; i++)
            {
                if(arr[i] < arr[i-1])
                {
                    swap(arr, i, i-1);
                }
            }
        }
    }

    public static int partition(int[] arr, int data)
    {
        int p = -1;
        int itr = 0;
        while(itr < arr.length)
        {
            if(arr[itr] <= data)
            {
                swap(arr, itr, ++p);
            }
            itr++;
        }
        return p;
    }

    public static int partitionWithPivotIdx(int []arr, int pivotIdx)
    {
        int n = arr.length;
        swap(arr, pivotIdx, n-1);
        int itr = 0;
        int p = -1;
        int li = n-1;
        while(itr < li)
        {
            if(arr[itr] <= arr[li])
            {
                swap(arr, itr, ++p);
            }
            itr++;
        }
        swap(arr, ++p, li);
        return p;
    }

    public static void insertionSort(int[] arr)
    {
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j > 0 && j < n; j--)
            {
                if(arr[j-1] > arr[j])
                swap(arr, j-1, j);
                else break;
            }
        }
    }

    public static void optimisedBubble(int[] arr)
    {
        boolean check = false;
        int count = 0;
        for(int li =  arr.length-1; li > 0; li++)
        {
            for(int i = 1; i <= li; i++)
            {
                if(arr[i-1] > arr[i])
                {
                    swap(arr, i, i-1);
                    check = true;
                }
            }

            count++;
            if(!check)
            break;
            
        }
        System.out.println(count);
    }

    public static void selectionSort(int[] arr)
    {
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(arr[i] > arr[j])
                swap(arr, i, j);
            }
        }
    }

    public static void swap(int[]arr , int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}