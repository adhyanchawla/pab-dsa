import java.util.*;

public class heappp9{

    public static void test1(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //.add
        //.remove
        //.peek
        for(int i = 10; i >= 1; i--)
        {
            pq.add(i*10);
        }

        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
    }

    public static void test2()
    {
        //max pq
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            return b - a;
        });
        for(int i = 10; i >= 1; i--)
        {
            pq.add(i*10);
        }

        while(pq.size() > 0){
            System.out.println(pq.remove());
        }

    }

    public static void test3()
    {
        int[][] arr = {{2, 6, 11, 3}, {8, 5, 16, 4}, {9, 7, 11, 13}, {8, 3, 12, 11}};

        PriorityQueue<int[]>pq1 = new PriorityQueue<>(arr.length, (a, b)->{
            return a[1] - b[1];
        });
        
        for(int[]a : arr)
        {
            pq1.add(a);
        }

        while(pq1.size() > 0)
        {
            int[]a = pq1.peek();
            for(int i = 0; i < a.length; i++)
            {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            pq1.remove();
        }

    }

    public static class mobilePhone{
        String Company = "";
        String Model = "";
        int Ram = 0;
        int Storage = 0;
        int BatteryBackup = 0;

        mobilePhone(String Company, String Model, int Ram, int Storage, int BatteryBackup)
        {
            this.Company = Company;
            this.Model = Model;
            this.Ram = Ram;
            this.Storage = Storage;
            this.BatteryBackup = BatteryBackup;
        }

        mobilePhone(){

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            
            sb.append("Company: " + this.Company + "\n");
            sb.append("Model: " + this.Model + "\n");
            sb.append("Ram: " + this.Ram + "GB\n");
            sb.append("Storage: " + this.Storage + "GB\n");
            sb.append("BatteryBackup: " + this.BatteryBackup + "mAH\n");
            
            return sb.toString();
        }
    }


    public static void main(String[] args)
    {
        //test3();

        mobilePhone m1 = new mobilePhone("Apple", "A1", 8, 32, 10);
        mobilePhone m2 = new mobilePhone("Apple", "A2", 32, 128, 20);
        mobilePhone m3 = new mobilePhone("Apple", "A3", 32, 128, 40);
        mobilePhone m4 = new mobilePhone("Apple", "A4", 24, 56, 40);
        mobilePhone m5 = new mobilePhone("Apple", "A5", 30, 100, 50);


        PriorityQueue<mobilePhone> pq = new PriorityQueue<>((a, b) ->{
            if(a.Ram != b.Ram)
            return b.Ram - a.Ram;
            else if(a.Storage !=  b.Storage)
            return b.Storage - a.Storage;
            else return b.BatteryBackup - a.BatteryBackup;
        });

        pq.add(m1);
        pq.add(m2);
        pq.add(m3);
        pq.add(m4);
        pq.add(m5);
        

        while(pq.size() > 0)
        {
            System.out.println(pq.peek().Company + " " + pq.peek().Model + " " + pq.peek().Ram + " " + pq.peek().Storage + " "+ pq.peek().BatteryBackup);
            pq.remove();
        }

    }

}