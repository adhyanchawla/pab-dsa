import java.util.*;

public class arrays {
    public static Scanner scn = new Scanner(System.in);

    public static void test1(int n) {
        // type[] nameOfArray = new type[size]; with default value 0.
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void display1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " "); // get
        }
    }

    public static void display2(int[] arr) {

        // forEach loop used for :
        // 1. only for get, if you try to set value ypu get a beutifull error.
        // 2. automatically increment by 1
        // 3. always in forward direction
        // 4. range of loop : [0 , n - 1]

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void input1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt(); // set
        }
    }

    public static int[] input2(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt(); // set
        }

        return arr;
    }

    public static int maximum(int[] arr){
        int max = -(int)1e9;
        for(int i = 0; i < arr.length; i++)
        {
            if(max < arr[i])
            {
                max = arr[i];
            }
        }
        return max;

    }

    public static int minimum(int[] arr){
        int min = (int)1e9; //Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            if(min > arr[i])
            {
                min = arr[i];
            }
        }
        return min;
    }

    // if you found return index, otherwise return -1.
    public static int find(int[] arr,int data){
        // better way is to declare variable

        int foundAtIndex = -1;
            for(int i = 0; i < arr.length; i++)
            {
                if(arr[i] == data)
                {
                    foundAtIndex = i;
                    break;
                }
            }
            return foundAtIndex;
    }
    public static void sumOfArrays(int[] arr, int[] arr1)
    {
        int n = 0;
        if(arr.length > arr1.length)
        {
            n = arr.length;
        }
        else{
            n = arr1.length;
        }
        int sum = 0;
        int c = 0;
        int []sum = new int[n + 1];
        int idx = n;
        int i = arr.length-1;
        int j = arr1.length-1;
        while(idx >= 0)
        {
            int sums = 0;
            if(i >= 0)
            {
                sum += arr[i];
            }
            if(j >= 0)
            {
                sum += arr1[j];
            }

            if(sum >= 10)
            {
                
            }
        }
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        int n1 = scn.nextInt();
        int[] arr = input2(n);
        int[] arr1 = input2(n1);
        System.out.println(maximum(arr));
        System.out.println(minimum(arr));
        System.out.println(find(arr, 16));
        System.out.println(find(arr, -8));
    }
}