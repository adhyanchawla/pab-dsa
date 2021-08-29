import java.util.*;

public class clientQueue {
    public static void main(String[] args) throws Exception {
        MyDynamicQueue mq = new MyDynamicQueue();
        mq.add(10);
        mq.add(20);
        mq.add(30);
        mq.add(40);
        mq.add(100);
        //System.out.println(mq.toString());
        mq.remove();
        mq.remove();
        mq.add(50);
        mq.add(60);
        mq.add(110);
        mq.add(120);
        mq.add(130);
        System.out.println(mq.toString());
    }
}
