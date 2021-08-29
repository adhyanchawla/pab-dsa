import java.util.*;

public class array2d {
    
    public static Scanner scn = new Scanner(System.in);

    public static int[][] input(int n, int m)
    {
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        return arr;
    }
    public static void display(int [][]arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n ; i++)
        {
            for(int j = 0; j < m; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int [][]arr = input(n, m);
        display(arr);
        int max = maximum(arr);
        System.out.println(max);
        int min = minimum(arr);
        System.out.println(min);
        int data = scn.nextInt();
        boolean f = find(arr, data);
        System.out.println(f);
        scn.close();
    }

    public static int maximum(int [][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        int max = -(int)1e9;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(max < arr[i][j])
                {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
    public static int minimum(int [][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        int min = (int)1e9;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(min > arr[i][j])
                {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }
    //javac filename.java && java filename < input.txt > output.txt

    public static boolean find(int [][] arr, int data)
    {
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(arr[i][j] == data)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void rotate(int [][]arr)
}
