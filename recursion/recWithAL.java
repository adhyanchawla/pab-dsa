import java.util.*;

public class recWithAL{

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        //int n = scn.nextInt();
        //int m = scn.nextInt();

        System.out.println(getKPC2(s));
    }

    public static ArrayList<String> getStr(String str)
    {
        if(str.length() == 0)
        {
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;   
        }
        if(str.charAt(0) == '0')
        {
            return new ArrayList<>();
        }
        ArrayList<String> myAns = new ArrayList<>();
        char ch = str.charAt(0);

        ArrayList<String>recAns = getStr(str.substring(1));

        for(String s : recAns)
        {
            myAns.add((char)('a' + ch - '1') + s);
        }

        if(str.length() > 1)
        {
            int num = (ch - '0') * 10 + (str.charAt(1) - '0');
            if(num <= 26)
            {
                ArrayList<String>recAns2 = getStr(str.substring(2));
                for(String s1 : recAns2)
                myAns.add((char)('a' + num - 1) + s1);
            }
        }


        return myAns;
    }

    public static String[] arr = {".;", "abc","def","ghi","jkl","mno","pqrs","tuv","wx","yz","+-*","<>/%"};

    public static ArrayList<String> getKPC2(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String>base = new ArrayList<>();
            base.add("");
            return base;
        }
        // if(str.charAt(0) == '0')
        // {
        //     return new ArrayList<>();
        // }

        char ch = str.charAt(0);
        ArrayList<String> recAns = getKPC2(str.substring(1));
        ArrayList<String> myRes = new ArrayList<>();
        String ans = arr[ch - '0'];

        for(int i = 0; i < ans.length(); i++)
        {
            char ch1 = ans.charAt(i);
            for(String s : recAns)
            {
                myRes.add(ch1 + s);
            }
        }
        if(str.length() > 1)
        {
            int num = (ch - '0')*10 + (str.charAt(1) - '0');
            if(num < arr.length)
            {
                ArrayList<String> recAns1 = getKPC2(str.substring(2));
                String ans1 = arr[num];

                for(int i = 0; i < ans1.length(); i++)
                {
                    char ch2 = ans1.charAt(i);

                    for(String s1 : recAns1)
                    {
                        myRes.add(ch2 + s1);
                    }
                }

            }
        }
        return myRes;

    }

    public static ArrayList <String> getKPC(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        String code = arr[ch - '0'];
        ArrayList<String>recAns = getKPC(str.substring(1));
        ArrayList<String>myAns = new ArrayList<>(); 

        for(int i = 0; i < code.length(); i++)
        {
            char ch1 = code.charAt(i);
            for(String s : recAns)
            {
                myAns.add(ch1 + s);
            }
        }
        return myAns;
    }

    public static ArrayList<String> getMazePaths(int sr,int sc, int dr, int dc)
    {
        if(sr > dr || sc > dc)
        {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        if(sr == dr && sc == dc)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList <String> hPath = new ArrayList<>();
        ArrayList <String> vPath = new ArrayList<>();
        ArrayList <String> dPath = new ArrayList<>();

        if(sc < dc)
        {
            hPath = getMazePaths(sr, sc+1, dr, dc);
        }
        if(sr < dr)
        {
            vPath = getMazePaths(sr+1, sc, dr, dc);
        }
        if(sr < dr && sc < dc)
        {
            dPath = getMazePaths(sr+1, sc+1, dr, dc);
        }

        ArrayList<String> mres = new ArrayList<>();

        for(String s : vPath)
        {
            mres.add("h" + s);
        }
        for(String s : hPath)
        {
            mres.add("v" + s);
        }
        for(String s : dPath)
        {
            mres.add("d" + s);
        }

        return mres;
       }
}