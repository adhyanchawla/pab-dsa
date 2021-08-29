import java.util.*;

public class patterns {

    public static void printNum(int n)
    {
        int nsp = n/2;
        //int k = 1;
        int numLoop = 1;
        for(int r = 1; r <= n; r++)
        {
            for(int csp = 1; csp <= nsp; csp++)
            {
                System.out.print("\t");
            }
            int k = r;
            if(r > (n/2)+1)
            {
                k = n - r + 1;
            }
            
                for(int i = 1; i <= numLoop; i++)
                {
                    System.out.print(k + "\t");
                    if(i <= numLoop/2)
                    k++;
                    else
                    k--;
                    //k++;       
                }
            System.out.println();
            if(r <= n/2)
            {
                nsp--;
                numLoop += 2;
            }
            else{
                nsp++;
                numLoop -= 2;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printNum(n);
        // int nst = n;
        // for(int r = 1; r <= n; r++)
        // {
        //     for(int cst = 1; cst <= nst; cst++)
        //     {
        //         System.out.print("*\t");
        //     }
        //     nst -= 1;
        //     System.out.println();
        // }
    }
}

import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int os = 1;
    int is = 1;
    
    
    for(int i = 1; i <= n; i++)
    {
        if(i == 1 || i == n)
        {
            for(int j = 1; j <= n; j++)
            {
                System.out.print("*\t");
            }
            System.out.println();
        }
        
        for(int j = 1; j <= os; j++)
        {
            System.out.print("\t");
        }
        if(i <= n/2)
        {
            System.out.print("*\t");
            for(int j = 1; j <= is; j++)
            {
                System.out.print("\t");
            }
            System.out.print("*\t");
        }
        if
        
    }
     // write ur code here

 }
}