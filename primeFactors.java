import java.util.*;

public class primeFactors {

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = scn.nextInt();

        for(int i = 2; i <= n; i++)
        {
            while(n % i == 0 && n > 0)
            {
                n = n / i;
                System.out.println(i);
            }
        }

    }
}
