import java.util.*;

public class practice{

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args)
    {
        //long num = scn.nextLong();
        // int n1 = scn.nextInt();
    
        // int []a1 = new int[n1];
        // for(int i = 0; i < n1; i++)
        // {
        //     a1[i] = scn.nextInt();
        // }
        
        // int n2 = scn.nextInt();
        // int []a2 = new int[n2];
        // for(int i = 0; i < n2; i++)
        // {
        //     a2[i] = scn.nextInt();
        // }
        
        //sumOfArrays(a1, a2);
        //diffofArrays(a1, a2);
        //int n = scn.nextInt();
        //int m = scn.nextInt();
        //int k = scn.nextInt();
        //forwardPrint(n);
        //comb(n);
        // int []qans = countNum(num);
        // for(int ele : qans)
        // {
        //     System.out.print(ele + " ");
        // }
        //int n = scn.nextInt();
        //int []arr = new int[n];
        // ArrayList<Integer> arr = new ArrayList<>();

        // arr.add(11);
        // arr.add(10);
        // arr.add(15);
        // arr.add(7);
        // arr.add(21);
        // arr.add(23);
        // for(int i = 0; i < n; i++)
        // {
        //     arr[i] = scn.nextInt();
        // }

        //removePrime(arr);

        //printSubarray(arr);
        removeData();

    }


    public static void removeData()
    {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 15; i++)
        {
            int a = scn.nextInt();
            arr.add(a);
        }

        int i =  arr.size()-1;
        while(i >= 0)
        {
            if(arr.get(i) == 10)
            {
                swap(arr, i, arr.size()-1);
                arr.remove(arr.size()-1);
            }
            i--;
        }

        System.out.println(arr);
    }

    public static void swap(ArrayList<Integer> arr, int i, int j)
    {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }


    public static boolean isPrime(int n)
    {
        for(int i = 2; i * i <= n; i++)
        {
            if(n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void removePrime(ArrayList<Integer> arr)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        for(int ele : arr)
        {
            if(!isPrime(ele))
            {
                ans.add(ele);
            }
        }
            arr.clear();

            for(int element : ans)
            {
                arr.add(element);
            }

            for(int el : arr)
            {
                System.out.println(el);
            }
        
    }

    public static void printSubarray(int []arr)
    {
        int si = 0;
        int ei = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                si = i;
                ei = j;
                while(si <= ei)
                {
                    System.out.print(arr[si]+ " ");
                    si++;
                }
                System.out.println();
            }
        }
    }

    public static int[] countNum(long n)
    {
        int[] ans = new int[10];

        while(n != 0)
        {
            long d = n % 10;
            ans[(int)d]++;
            n = n / 10;
        }
        return ans;
    }

    public static void diffofArrays(int []a1, int[] a2)
    {
        int size = a2.length;
        int []ans = new int[size];
        int m = a1.length-1;
        int n = a2.length-1;
        int k = a2.length-1;
        int c = 0;
        int diff = 0;

        while(k >= 0)
        {
            int d1 = m>= 0 ? a1[m] : 0;
            int d2 = n>= 0 ? a2[n] : 0;
            
            if(d2 + c >= d1)
            {
                diff = (d2 + c) - d1;
                c = 0; 
            }
            else if(d2 + c + 10 >=  d1)
            {
                diff = d2 + c + 10 - d1;
                c = -1;
            }

            ans[k] = diff;

            m--;
            n--;
            k--;
        }

        int idx = 0;
        int i = 0;
        for(i = 0; i < ans.length ; i++)
        {
            if(ans[i] == 0)
            {
                continue;
            }
            else
            {
                idx = i;
                break;
            }
        }

        if(i == ans.length)
        {
            System.out.println(0);
            return;
        }

        for(idx = idx; idx < ans.length; idx++)
        {
            System.out.print(ans[idx] + " ");
        }
    }

     public static void sumOfArrays(int []a1, int []a2)
 {
     int size = Math.max(a1.length, a2.length) + 1;
     int []a = new int[size];
     
     int m = a1.length-1;
     int n = a2.length-1;
     int k = a.length -1;
     
     int c = 0;
     int ans1 = 0;
     while(k >= 0)
     {
         int d = c + (m >= 0 ? a1[m] : 0) + (n >= 0 ? a2[n] : 0);
         
         if(d > 9)
         {
             ans1 = d % 10;
             c = d /10;
         }
         else
         {
             ans1 = d;
             c = 0;
         }
         
         a[k] = ans1;
         k--;
         m--;
         n--;
     }
     int ans = 0;
     for(int i = 0; i < a.length; i++)
     {
        if(i < a.length && a[i] == 0)
        {
            continue;
        }
        else
        {
            ans = i;
            break;
        }
     }
     
     for(ans = ans; ans < a.length; ans++)
     {
         System.out.println(a[ans]);
     }
     
 }

    public static void comb(int n)
    {
        int ans = 1;
        for(int i = 0; i < n; i++)
        {
            ans = 1;
            for(int j = 0; j <= i; j++)
            {
                System.out.print(ans + "\t");
                int ans1 = ((i-j)*ans)/(j+1);
                ans = ans1;
            }
            System.out.println();
        }
    }

    public static void pattern01(int n)
    {
        int nsp = n/2;
        int nst = 1;
        int d = 0;
        for(int r = 1; r <= n; r++)
        {
            for(int csp = 1; csp <= nsp; csp++)
            {
                System.out.print(" " + "\t");
            }

            if(r <= n/2 + 1)
            {
                d = r;
            }
            else
            {
                d = n - r + 1;
            }

            for(int cst = 1; cst <= nst; cst++)
            {
                if(cst <= nst/2)
                {
                    System.out.print(d + "\t");
                    d++;
                }
                else if(cst == nst/2 + 1)
                {
                    System.out.print(d + "\t");
                    d--;
                }
                else if(cst > nst/2 + 1)
                {
                    System.out.print(d + "\t");
                    d--;
                }
            }

            if(r <=  n/2)
            {
                nsp--;
                nst += 2;
            }
            else
            {
                nsp++;
                nst -= 2;
            }
            System.out.println();
        }
    }

    public static void primeFact(int n)
    {
        for(int i = 2; i <= n; i++)
        {
            while(n % i == 0 && n > 1)
            {
                System.out.print(i + " ");
                n = n/i;
            }
        }
    }

    public static void inverse(int n)
    {
        int oi = 1;
        int nd = 0;
        while(n > 0)
        {
            int od = n % 10;
            
            int ni = od;
            nd += oi * power(ni - 1);
            
            n = n / 10;
            oi++;
        }
        System.out.println(nd);
    }

    public static void gcdlcm(int n1, int n2)
    {
        int gcd = 0;
        int on1 = n1;
        int on2 = n2;
        while(n1 % n2 != 0)
        {
            int ans = n1 % n2;
            n1 = n2;
            n2 = ans;
        }
        gcd = n2;
        System.out.println(gcd);

        int lcm = (on1 * on2) / gcd;
        System.out.println(lcm);
    }

    public static int countDigits(int n)
    {
        int c = 0;
        while(n > 0)
        {
            c++;
            n = n/10;
        }
        return c;
    }

    public static int power(int count)
    {
        int pow = 1;
        for(int i = 1; i <= count; i++)
        {
            pow *= 10;
        }
        return pow;
    }

    public static void rotateNum(int n, int k)
    {
        int c = countDigits(n);
        k = k % c;
        if(k < 0)
        {
            k = k + c;
        }
        int mult = 1;
        int div = 1;
        for(int i = 1; i <= c; i++)
        {
            if(i <= k)
            {
                div *= 10;
            }
            else
            {
                mult *= 10;
            }
        }
        System.out.println((n % div)*mult + n/div);
    }

    public static void forwardPrint(int n)
    {
        int count = countDigits(n);
        int ans = 0;
        int mult = 1;
        while(n > 0)
        {
            int d = n / power(count-1);
            d  = d * mult;
            ans += d;
            n = n % power(count-1);
            count--;
            mult = mult *10;
        }

        System.out.println(ans);

    }
}