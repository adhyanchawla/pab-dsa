import java.util.*;

public class targetthreesum {
    
    public static void main(String[] args)
    {
        
        int[] arr = {-2, -3, 7, 5, 8, 15, 3, 2, 9, 10, 19};
        targetthreesum1(arr, 25);
    }

    public static ArrayList<int[]> twoSum(int[] arr, int target, int si, int ei)
    {
        //to implement pair feature
        ArrayList<int[]> ans = new ArrayList<>();
        while(si < ei)
        {
            int sum = arr[si] + arr[ei];
            if(sum == target){
                ans.add(new int[]{ arr[si++], arr[ei--] });
            }
            else if(sum > target){
                ei--;
            }
            else{
                si++;
            }
        }

        return ans;
    }

    public static ArrayList<int[]> threeSum(int[] arr, int target, int si, int ei){
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = si; i <= ei; i++)
        {
            ArrayList<int[]> smallAns = twoSum(arr, target - arr[i], i+1, ei);

            for(int[]a : smallAns)
            {
                ans.add(new int[] { arr[i], a[0], a[1]}); 
            }
        }

        return ans;
    }
    
    public static void targetthreesum1(int[]arr, int target){
        int n = arr.length;
        quickSort(arr, 0, n-1);
        ArrayList<int[]> ans = threeSum(arr, 25, 0, n-1);
        for(int[] a : ans)
        {
            System.out.println(a[0] + ", " + a[1] + ", " + a[2]);
        }
    }

    // public static void targetSum(int[] arr, int target){
    //     int lo = 0;
    //     int next = 1;
    //     int hi = arr.length-1;
    //     int prev = hi;
    //     while(lo < hi)
    //     {//-2 -3 7 5 8 15 3 2 9 10 19
    //         next = lo + 1;
    //         prev = hi;
    //         while(next < prev)
    //         {
    //             if(arr[lo] + arr[next] + arr[hi] > target)
    //             {
    //                 prev--;
    //             }
    //             else if(arr[lo] + arr[next] + arr[hi] < target)
    //             {
    //                 next++;
    //             }
    //             else{
    //                 System.out.println(arr[lo]+ " " + arr[next] + " " + arr[hi]);
    //                 next++;
    //                 hi--;
    //                 //break;
    //             }
    //         }
    //         lo++;
    //         hi--;
    //     }

    // }

    public static void swap(int[]arr, int lo, int hi)
    {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }

    public static int partition(int[]arr, int pIdx, int lo, int hi)
    {
        swap(arr, pIdx, hi);

        int p = lo -1;
        int itr = lo;
        while(itr <= hi)
        {
            if(arr[itr] <= arr[hi])
            {
                swap(arr, itr, ++p);
            }
            itr++;
        }
        return p;
    }

    public static void quickSort(int[] arr, int lo, int hi)
    {
        if(lo > hi)
        return;

        int pIdx = hi;
        int p = partition(arr, pIdx, lo, hi);

        quickSort(arr, lo, p-1);
        quickSort(arr, p + 1, hi);
    }
}
