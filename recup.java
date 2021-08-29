import java.util.*;

public class recup {

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printPermutations(str);
    }


    public static void printPermutations(String str)
    {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++)
        {
            freq[str.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++)
        {
            for(int j = 0; j < freq[i]; j++)
            {
                sb.append((char)(i + 'a'));
            }
        }

        int ans = printPermutationsWithoutDuplicates(sb.toString(), "");
        System.out.println(ans);
    }

    public static int printPermutationsWithoutDuplicates(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char prev = '0';

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != prev)
            {
                String ros = str.substring(0, i) + str.substring(i+1);
                count += printPermutationsWithoutDuplicates(ros, ans + str.charAt(i));
            }
            prev = str.charAt(i);
        }

        return count;
    }

    // public static int boardPath(int n, String ans)
    // {
    //     if(n == 0)
    //     {
    //         //System.out.println(ans);
    //         return 1;
    //     }

    //     int count = 0;
    //     for(int i = 1; i <= 6 && n - i >= 0; i++)
    //     {
    //         count += boardPath(n - i, ans + i);
    //     }

    //     return count;
    // }

    // public static int boardPath01(int []arr, int n, String ans)
    // {
    //     if(idx == arr.length)
    //     {
    //         System.out.println(ans);
    //         return 1;
    //     }
    // }
    
}
