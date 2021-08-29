import java.util.*;

public class mergesort {
    
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int []arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }

        arr = mergeSort(arr, 0, arr.length-1);
        for(int ele : arr)
        {
            System.out.print(ele + " ");
        }
    }


    // faith 2 sorted arrays milenge
    public static int[] mergeTwoSortedArrays(int []arr1, int[] arr2)
    {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        int[] ans = new int[m+n];
        int k = 0;
        while(i < n && j < m)
        {
            if(arr1[i] >= arr2[j])
            {   
                ans[k++] = arr2[j++];
            }
            else if(arr2[j] > arr1[i])
            {
                ans[k++] = arr1[i++];
            }
        }

        while(i < n)
        {
            ans[k++] = arr1[i++];
        }
        while(j < m)
        {
            ans[k++] = arr2[j++];
        }

        return ans;
    }


    public static int[] mergeSort(int[]arr, int si, int ei)
    {
        if(si == ei)
        {
            return new int[] { arr[si] };
        }

        int mid = (si + ei)/2;
        int[] arr1 = mergeSort(arr, si, mid);
        int[] arr2 = mergeSort(arr, mid+1, ei);
        int[] ans = mergeTwoSortedArrays(arr1, arr2);

        return ans;
    }

}
