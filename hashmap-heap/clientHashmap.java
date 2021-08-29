public class clientHashmap {

    public static void test(){
        hashmap01 hm = new hashmap01();
        hm.put(100, 1);
        hm.put(200, 3);
        hm.put(300, 5);
        hm.put(400, 6);
        hm.put(200, 11);

        System.out.println(hm.keySet());
    }

    public static void main(String[] args){
        test();
    }
    
}
