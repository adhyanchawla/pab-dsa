import java.util.*;

public class print1 {

    public static Scanner scn = new Scanner(System.in);

    public static void printTable(int n)
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.println(n + " X " + i + " = " + n*i);
        }
    }

    public static void printAllTables(int num)
    {
        for(int i = 1; i <= num; i++)
        {
            printTable(i);
            System.out.println();
        }
    }

    public static void isPrime(int num)
    {
        int count = 0;
        for(int i = 2; i*i <= num; i++)
        {
            if(num % i == 0)
            {
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println(num);
        }
    }

    public static void isPrimeTillN(int a, int b)
    {
        for(int i = a; i <= b; i++)
        {
            isPrime(i);
        }
    }

    public static void main(String[] args)
    {
        int a = scn.nextInt();
        int b = scn.nextInt();
        isPrimeTillN(a, b);
        //printAllTables(num);
        //System.out.println("Hello, world");
    }
    
}