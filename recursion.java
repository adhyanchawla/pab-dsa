import java.util.*;

public class recursion {

    public static void p(int a, int b)
    {
        if(a > b)
        return;

        System.out.println(a);
        p(a+1, b);
    }

    public static int recursionTree(int n) {
        if (n <= 1) {
            System.out.println("Base: " + n);
            return n + 1;
        }

        int count = 0;

        System.out.println("Pre: " + n);
        count += recursionTree(n - 1);

        System.out.println("In: " + n);
        count += recursionTree(n - 2);

        System.out.println("Post: " + n);

        return count + 3;
    }

    public static int recursionTree2(int n) {
        if (n <= 1) {
            System.out.println("Base: " + n);
            return n + 1;
        }

        int count = 0;

        System.out.println("Pre: " + n);
        count += recursionTree2(n - 1);

        System.out.println("In1: " + n);
        count += recursionTree2(n - 2);

        System.out.println("In2: " + n);
        count += recursionTree2(n - 3);

        System.out.println("Post: " + n);
        return count + 3;
    }

    public static void printArray(int []arr, int n)
    {
        if(n == arr.length)
        {
            return;
        }
        
        System.out.println(arr[n]);
        printArray(arr, n+1);
    }

    public static void printReverseArray(int []arr, int n)
    {
        if(n == arr.length)
        {
            return;
        }
        
        printReverseArray(arr, n+1);
        System.out.println(arr[n]);
    }

    public static int maxi(int []arr, int n)
    {
        if(n == arr.length)
        {
            return -(int)1e9;
        }

        int max = maxi(arr, n+1);
        if(max < arr[n])
        {
            return arr[n];
        }
        else return max;
    }

    public static int mini(int[] arr, int n)
    {
        if(n == arr.length)
        return (int)1e9;

        int min = mini(arr, n+1);
        if(min > arr[n])
        return arr[n];
        else return min;
    }

    // public static boolean findData(int []arr, int n, int data)
    // {
    //     if(n == arr.length)
    //     return false;

    //     if(arr[n] == data)
    //     {
    //         return true;
    //     }
    //     else boolean f = findData(arr, n + 1, data);
        

    // }

    public static boolean findData2(int []arr, int idx, int data)
    {   
        if(idx == arr.length)
        return false;

        boolean f = findData2(arr, idx+1, data); //returns true or false have faith
        if(f){
            System.out.println("found");
        return true;}

        System.out.println("Not found");
        return arr[idx] == data;
    }

    public static int maximum1(int []arr, int n)
    {
        if(n == arr.length)
        return -(int)1e9;

        return maximum1(arr, n+1) > arr[n] ? maximum1(arr, n+1) : arr[n];
    }


    public static int fI(int []arr, int n, int data)
    {
        if(n == arr.length)
        return -1;
        if(arr[n] == data){
            System.out.println("found");
        return n;}
            System.out.println("Not found");
        return fI(arr, n+1, data);
    }

    public static boolean firstAndLastIdx(int[] arr, int idx, int data, int[] ans) {
        if (idx == arr.length)
            return false;
        if (arr[idx] == data)
            ans[0] = idx;

        boolean res = firstAndLastIdx(arr, idx + 1, data, ans);
        if (res)
            return true;

        if (arr[idx] == data) {
            ans[1] = idx;
            return true;
        }

        return false;
    }


    public static int lI(int []arr, int n, int data)
    {
        if(n ==  arr.length)
        return -1;

        int recAns = lI(arr, n+1, data);
        if(recAns != -1){
        System.out.println("found");    
        return recAns;
        }
        System.out.println("not found");

        return arr[n] == data ? n : -1;
    }

    public static int[] allIndeces(int []arr, int idx, int data, int count)
    {
        if(idx == arr.length)
        {
            return new int[count];
        }

        if(arr[idx] == data)
        {
            count++;
        }

        int []iarr = allIndeces(arr, idx + 1, data, count);

        if(arr[idx] == data)
        {
            iarr[count-1] = idx;
        }

        return iarr;

    }

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        //int n = scn.nextInt();
        int []arr = {11, 22, 2, 10, 4, 2, 8, 22};
        //printReverseArray(arr, 0);
        int max = maxi(arr, 0);
        int min = mini(arr, 0);
        int []ans = new int[2];
        System.out.println(maximum1(arr, 0));
        System.out.println(lI(arr, 0, 2));

        int []a = allIndeces(arr, 0, 2, 0);
        for(int ele : a)
        {
            System.out.println(ele);
        }
        //System.out.println(max);
        //System.out.println(min);
        //System.out.println(firstAndLastIdx(arr, 0, 3, ans));
        // for(int ele : ans)
        // System.out.println(ele);
    }
}


// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws Exception {
//         // write your code here
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<arr.length;i++){
//             arr[i] = scn.nextInt();
//         }
//         int x = scn.nextInt();
//         System.out.println(lastIndex(arr,0,x));
//     }

//     public static int lastIndex(int[] arr, int idx, int x){
//         if(idx==arr.length){
//             return -1;
//         }
//         int ldx = lastIndex(arr,idx+1,x);
//        if(ldx==-1){
//            if(arr[idx]==x){
//                return idx;
//            }else{
//                return -1;
//            }
//        }else{
//            return ldx;
//        }