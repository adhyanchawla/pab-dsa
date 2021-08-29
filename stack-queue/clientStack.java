import java.util.*;

public class clientStack {
    
    public static void main(String[] args)  throws Exception{
        MyDynamicStack ms = new MyDynamicStack();
        ms.push(10);
        ms.push(20);
        ms.push(30);
        ms.push(40);
        ms.push(50);
        ms.push(60);

        System.out.println(ms.toString());
        //ms.toString();
    }
}
