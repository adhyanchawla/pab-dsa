import java.util.*;

public class hashmap {
    
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        //HashMap<String, Integer> map = new HashMap<>();
        
        // //insertion
        // map.put("India", 100);
        // map.put("SriLanka", 150);
        // map.put("China", 50);
        // map.put("Pak", 120);

        // System.out.println(map);
        
        // //updation
        // map.put("India", 200);
        // System.out.println(map);

        // //get
        // System.out.println(map.get("China"));
        // System.out.println(map.get("Pak"));

        // //containsKey
        // System.out.println(map.containsKey("England"));

        // //remove
        // System.out.println(map.remove("China"));
        // System.out.println(map.remove("China"));

        // System.out.println(map);

        // //set
        // Set<String> s = map.keySet();
        // for(String key : s)
        // System.out.println(key + " -> " + map.get(key));
        // System.out.println();

        // //store in arraylist
        // ArrayList<String> arr = new ArrayList<>(map.keySet());
        // for(String ss : arr)
        // {
        //     int val = map.get(ss);
        //     System.out.println(ss);
        //     System.out.println(val);
        //     System.out.println();
        // }

        String str = scn.nextLine();
        //System.out.println(getFreq(str));
        indexOfChar(str);
    }

    public static char getFreq(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                map.put(ch, count + 1);
            }
            else{
                map.put(ch, 1);
            }
        }

        for(Character c : map.keySet()){
            System.out.println(c + " -> " + map.get(c));
        }

        //another way of calculating the frequency

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = -1;
        char ch = '\u0000';
        for(Character c : map.keySet()){
            if(map.get(c) > max){
                max = map.get(c);
                ch = c;
            }
        }
        return ch;
    }

    public static void indexOfChar(String str){
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        // for(int i = 0; i < str.length(); i++){

        //     char ch = str.charAt(i);
        //     if(!map.containsKey(ch)){
        //         map.put(ch, new ArrayList<>());
        //     }
        //     map.get(ch).add(i);
        // }

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        for(char ch : map.keySet()){
            System.out.println(ch + " -> " +  map.get(ch));
        }
    }
}
