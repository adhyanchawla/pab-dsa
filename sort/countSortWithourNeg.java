import java.util.*;

public class countSortWithourNeg{

    public static void main(String[] args)
    {
        int[] arr = {3, 5, -17, -4, 11, 17, 5, 6, 8, -2, -11, -2, 13, 15, 19};
        countsort(arr);
        for(int ele : arr)
        {
            System.out.print(ele + " ");
        }
    }

    public static void countsort(int[] arr)
    {
        int min = (int)1e9;
        int max = -(int)1e9;

        for(int ele : arr)
        {
            max = Math.max(max, ele);
            min = Math.min(min, ele);
        }

        int range = max - min + 1;

        int []freq = new int[range];

        for(int ele : arr)
        {
            freq[ele - min]++;
        }

        int idx = 0;
        for(int i = min; i <= max; i++)
        {
            while(freq[i - min]-- > 0)
            {
                arr[idx++] = i;
            }
        }
    }
    
}