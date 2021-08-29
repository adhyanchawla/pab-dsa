import java.util.*;
//StringBuilder sb = new StringBuilder


public class arraylist{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String []args)
    {
        ArrayList <Integer> a = new ArrayList<Integer>();
        removeData();
        // for(int i = 0; i < 5; i++)
        // {
        //     int inp = scn.nextInt();
        //     a.add(inp);
        // }
        // System.out.println(removePrime(a));
    }

    public static ArrayList<Integer> removePrime(ArrayList <Integer> a)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int count = 0;
        for(int i = 0; i < a.size(); i++)
        {
            count = 0;
            for(int j = 2; j * j <= a.get(i); j++)
            {
                if(a.get(i) % j == 0)
                {
                    count++;
                }
            }
            if(count != 0)
            {
                arr.add(a.get(i));
            }
        }
        return arr;

    }

    public static void swap(ArrayList<Integer>arr, int i, int j)
    {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void removeData()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < 15; i++)
        {
            int a = scn.nextInt();
            arr.add(a);
        }
        int data = scn.nextInt();
        int n = arr.size();
        //int j = arr.size()-1;
        int i = arr.size()-1;

        while(i >= 0)
        {
            if(arr.get(i) == data)
            {
                swap(arr,i,arr.size()-1);
                arr.remove(arr.size()-1);
                
            }
            i--;
            
        }

        System.out.println(arr);

    }
}