import java.util.*;

public class numbers{

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args)
    {   
        //Scanner scn = new Scanner(System.in);   
        // long n = scn.nextLong();
        // int []query = new int[scn.nextInt()];
        // for(int i = 0; i < query.length; i++)
        // {
        //     query[i] = scn.nextInt();
        // }
        // int []ans = digitFreq(n, query);
        // for(int ele : ans)
        // {
        //     System.out.println(ele);
        // }
        int n = scn.nextInt();

        
        decimalToBinary(n);
        
        //binaryToDecimal(n);
    }

    public static int[] digitFreq(long n, int []query)
    {
        int []ans = new int[10];
        while(n != 0)
        {
            //typecast pehle ni krna
            long d = (n % 10);
            ans[(int)d]++; 
            //yha typecast krro                     O(n) space time O(q)
            n = n/10;
        }
        return ans;
    }

    public static int power(int n){
        int pow = 1;
        for(int i = 1; i <= n; i++)
        {
            pow = pow*2;
        }
        return pow;
    }
    public static void decimalToBinary(int n)
    {
        // 1010111
        int sum = 0;
        int mult = 1;
        while(n != 0)
        {
            int d = n % 2;
            sum += d * mult;
            mult = mult * 10;
            n = n /2;
        }
        System.out.println(sum);
    }
    public static void binaryToDecimal(int n){
        int count = 0;
        int ans = n;
        while(ans != 0)
        {
            count++;
            ans = ans/2;
        }
        int i = 0;
        int sum = 0;
        while(n != 0)
        {
            int d = n % 10;
            if(d > 0) 
            d = power(i);
            sum += d;
            i++;
            n = n/10;
        }
        System.out.println(sum);
    }
}









