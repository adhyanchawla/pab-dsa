import java.util.*;

public class string {
    public static int findHi(String str)
    {
        int n = str.length();
        int i = 0;
        int count = 0;
        while(i < n - 1)
        {
            if(str.charAt(i) == 'h' && str.charAt(i+1) == 'i')
            {
                if(str.charAt(i+2) == 't' && i < n-2)
                {
                    i += 3;
                }
                else
                {
                    count++;
                    i += 2;
                }
            }
            else
            {
                i++;
            }
            
        }
        return count;
        // if(str.charAt(str.length()-2) == 'h' && str.charAt(str.length()-1) == 'i'){
        //     return count + 1;
        // }
        // else return count;
    }

    public static boolean isPalindrome(String str)
    {
        int i = 0;
        int j = str.length() - 1;
        //we dont want to print empty spaces
        while(i < j)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void printPalindrome(String str)
    {
        int n = str.length();
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j <= n; j++)
            {
                boolean isPal = isPalindrome(str.substring(i, j));
                if(isPal)
                {
                    System.out.println(str.substring(i, j));
                }
            }
        }
    }

    public static void removeHiExceptHit(String str)
    {
        int n = str.length();
        int i = 0;
        String ans = "";
        while(i < n)
        {
            if(i < n - 1 && (str.charAt(i) == 'h' && str.charAt(i+1) == 'i'))
            {
                if(i < n - 2 && str.charAt(i+2) == 't')
                {
                    ans += "hit";
                    i += 3;
                }
                else
                {
                    i += 2;
                }
            }
            else
            {
                ans += str.charAt(i);
                i++;
            }
        }
        System.out.println(ans);
    }

    public static void stringComp1(String str)
    {
        int n = str.length();
        int i = 1;
        int count = 1;
        String ans = str.charAt(0) + "";
        while(i < n)
        {
            while(i < n && ans.charAt(ans.length()-1) == str.charAt(i))
            {
                i++;
                count++;
            }

            if(count > 1)
            {
                ans += count;
                count = 1;
            }
            if( i < n)
            {
                ans += str.charAt(i);
            }
            i++;
        }
        System.out.println(ans);
    }

    public static void removeHi(String str)
    {
        int n = str.length();
        int i = 0;
        String ans = "";
        while(i < n)
        {
            if(i < n-1 && (str.charAt(i) == 'h' && str.charAt(i+1) == 'i'))
            {
                i += 2;
            }
            else
            {
                ans += str.charAt(i);
                i++;
            }
        }
        System.out.println(ans);
    }

    public static void stringCompression(String str)
    {
        int n = str.length();
        int i = 1;
        String ans = str.charAt(0) + "";
        int changes = 0;
        while(i < n){
        while(i < n && ans.charAt(ans.length()-1) == str.charAt(i))
        i++;
        
        changes++;
        if(i < n)
        ans += str.charAt(i);

        i++;
    }
    System.out.println(ans);
    System.out.println(changes);
    }


    public static void main(String[] args)
    {
        String str = "hithithihihabcdhit";
        System.out.println((char)(122));
        //printPalindrome(str);
        //stringCompression(str);
        //stringComp1(str);
        //removeHi(str);
        //removeHiExceptHit(str);
        //System.out.println(findHi(str));
    }
}