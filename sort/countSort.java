import java.util.*;

public class countSort {
    
    public static void main(String[] args)
    {
        int[] arr = {3, 5, 17, 4, 11, 17, 5, 6, 8, 2, 11, 2, 13, 15, 19};
        countsort(arr);
        for(int ele : arr)
        {
            System.out.print(ele + " ");
        }
    }

    public static void countsort(int []arr)
    {
        int max = -(int)1e9;

        for(int ele : arr)
        {
            max = Math.max(max, ele);
        }

        int range = max - 0 + 1;
        int[] freq = new int[range];
        for(int ele : arr)
        {
            freq[ele]++;
        }
        int idx = 0;
        for(int i = 0; i < range; i++)
        {
            while(freq[i]-- > 0)
            {
                arr[idx++] = i;
            }
        }
    }
}
