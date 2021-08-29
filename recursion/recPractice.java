import java.util.*;

public class recPractice {
    
    public static void main(String[] args){
        int []arr = {1, 2, 5, -7, 2, 12, 11, 2, 2};
        //System.out.println(mazePaths1(0, 0, 2, 2, ""));

        permutation("aab");
        //int[]ans = allIndeces(arr, 0, 0, 2);
        //String str = "11283";
        //getSubsequence2("abc","");
        //System.out.println(ans);
        // for(String s : ans)
        // {
        //     System.out.print(s + " ");
        // }
        // for(int ele : ans){
        //     System.out.print(ele + " ");
        // }
    }

    public static boolean find(int[] arr, int idx, int data)
    {
        if(idx == arr.length)
        return false;

        if(arr[idx] == data)
        {
            return true;
        }
        else
        return find(arr, idx + 1, data);
    }

    public static int firstIdx(int[] arr, int idx, int data)
    {
        if(idx == arr.length)
        return -1;
        
        if(arr[idx] == data)
        return idx;
        else return firstIdx(arr, idx + 1, data);
    }

    public static int lastIdx(int[] arr, int idx, int data){
        if(idx == arr.length){
            return -1;
        }

        int recAns = lastIdx(arr, idx + 1, data);
        if(recAns != -1)
        {
            return recAns;
        }
        else{
            if(arr[idx] == data)
            {
                return idx;
            }
            else return -1;
        }

    }

    public static int[] allIndeces(int[] arr, int idx, int count, int data)
    {
        if(idx == arr.length){
            return new int[count];
        }

        
        if(arr[idx] == data){
            count++;    
        }

        int []recAns = allIndeces(arr, idx + 1, count, data);

        if(arr[idx] == data)
        recAns[count-1] = idx;

        

        return recAns;
    }

    public static ArrayList<String> getSubsequence(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> recAns = getSubsequence(str.substring(1));
        ArrayList<String> myAns = new ArrayList<>();

        for(String s : recAns)
        {
            myAns.add("" + s);
            myAns.add(ch + s);
        }

        return myAns;
    }

    public static String[] keys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> nokiaKeys(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }


        char ch = str.charAt(0);
        ArrayList<String> recAns = nokiaKeys(str.substring(1));
        int idx = ch - '0';
        String s = keys[idx];
        ArrayList<String> myAns = new ArrayList<>();
        for(int i = 0; i < s.length(); i++)
        {
            char ch1 = s.charAt(i);
            
            for(String ele: recAns)
            {
                myAns.add(ch1 + ele);
            }
        }

        return myAns;
    }

    public static ArrayList<String> decodeWays(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if(str.charAt(0) == '0')
        return new ArrayList<>();

        char ch = str.charAt(0);
        //int digit = ch - '0';
        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> recAns = decodeWays(str.substring(1));
        for(String ele : recAns)
        {
            myAns.add((char)('a' + ch - '1') + ele);
        }
        

        if(str.length() > 1)
        {
            int num = (ch - '0')*10 + (str.charAt(1) - '0');
            if(num <= 26)
            {
                //char ans = (char)('a' + num - 1);
                ArrayList<String> recAns2 = decodeWays(str.substring(2));
                for(String ele : recAns2)
                {
                    myAns.add((char)('a' + num - 1) + ele);
                }

            }
        }

        return myAns;

    }


    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc)
    {
        if(sr == dr && sc == dc)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for(int jump = 1; jump + sr <= dr; jump++){
            ArrayList<String> recAns1 = getMazePaths(sr+jump, sc, dr, dc);
            for(String ele : recAns1)
            {
                myAns.add("v"+ jump +ele);
            }
        }

        for(int jump = 1; jump + sc <= dc; jump++){
            ArrayList<String> recAns2 = getMazePaths(sr, sc+jump, dr, dc);
            for(String ele : recAns2)
            {
                myAns.add("h"+jump+ele);
            }
        }

        for(int jump = 1; jump + sr <= dr && jump + sc <= dc; jump++){
            ArrayList<String> recAns3 = getMazePaths(sr+jump, sc+jump, dr, dc);
            for(String ele : recAns3)
            {
                myAns.add("d"+jump+ele);
            }
        }

        return myAns;
    }

    public static void getSubsequence2(String ques, String ans)
    {
        if(ques.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);

        getSubsequence2(ques.substring(1), ans + "");
        getSubsequence2(ques.substring(1), ans + ch);
        

    }

    public static int stairPath1(int n, String psf)
    {
        if(n == 0)
        {
            System.out.println(psf);
            return 1;
        }

        int count = 0;

        for(int i = 1; i <= 3; i++)
        {
            if( n - i >= 0)
            count += stairPath1(n-i, psf + i);
        }

        return count;
    }

    public static int mazePaths1(int sr, int sc, int dr, int dc, String psf)
    {
        if(sr == dr && sc == dc)
        {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        if(sr + 1 <= dr)
        {
            count += mazePaths1(sr + 1, sc, dr, dc, psf + "v");
        }
        if(sc + 1 <= dc && sr + 1 <= dr)
        {
            count += mazePaths1(sr + 1, sc + 1, dr, dc, psf + "d");
        }
        if(sc + 1 <= dc)
        {
            count += mazePaths1(sr, sc + 1, dr, dc, psf + "h");
        }

        return count;
    }

    public static int multipleJumpsPaths(int sr, int sc, int dr, int dc, String psf)
    {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for(int j = 1; j + sr <= dr; j++)
        {
            count += multipleJumpsPaths(sr + j, sc, dr, dc, psf + "v" + j);
        }

        for(int j = 1; j + sc <= dc; j++)
        {
            count += multipleJumpsPaths(sr, sc + j, dr, dc, psf + "h" + j);
        }
        for(int j = 1; j + sr <= dr && j + sc <=  dc; j++)
        {
            count += multipleJumpsPaths(sr + j, sc + j, dr, dc, psf + "d" + j);
        }

        return count;
    }

    // public static int printPermutations(String str, String ans)
    // {
    //     if(str.length() == 0)
    //     {
    //         System.out.println(ans);
    //         return 1;
    //     }

    //     int count = 0;

    //     for(int i = 0; i < str.length(); i++)
    //     {
    //         char ch = str.charAt(i);
    //         count += printPermutations(str.substring(0,i)+ str.substring(i+1), ans + ch);
    //     }

    //     return count;
    // }


    public static void permutation(String str)
    {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];

        for(int i = 0; i < str.length(); i++)
        {
            freq[str.charAt(i)-'a']++;
        }

        for(int i = 0; i < freq.length; i++)
        {
            int count = freq[i];
            while(count > 0)
            {
                sb.append((char)('a' + i));
                count--;
            }
        }
        //System.out.println(sb);
        int ans = printPermutations(sb.toString(), "");
        System.out.println(ans);
    }


    public static int printPermutations(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char prev = '$';

        for(int i = 0; i < str.length(); i++)
        {
            char curr = str.charAt(i);
            if(prev != curr)
            {
                count += printPermutations(str.substring(0, i) + str.substring(i+1), ans + curr);
            }
            prev = curr;
        }
        return count;
    }
}























