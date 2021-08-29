import java.util.*;

public class rotate{

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = scn.nextInt();
        int k = scn.nextInt();

        int c = count(n);
        int mult = 1;
        int div = 1;

        k = k % n;
        
        if(k < 0)
        {
            k = k + c;
        }


        for(int i = 1; i <= c; i++)
        {
            if(i <= k)
            {
                div = div * 10;
            }
            else
            {
                mult = mult * 10;
            }
        }

        int a = n % div;
        int b = n / div;

        int ans = a * mult + b;

        System.out.println(ans);
    }

    public static int count(int n)
    {
        int c = 0;
        while(n != 0)
        {
            c++;
            n /= 10;
        }
        return c;
    }
}