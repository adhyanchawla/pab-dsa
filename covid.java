import java.util.*;

public class covid {
    public static class Pair implements Comparable <Pair>{
        String state;
        int cases;

        public Pair(String state, int cases){
            this.state = state;
            this.cases = cases;
        }

        public int compareTo(Pair o)
        {
            return this.cases - o.cases;
        }
    }

    public static void main(String[] args)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(new Pair("Haryana", 10000));
        pq.add(new Pair("Gujarat", 50000));
        pq.add(new Pair("Kerela", 80000));
        pq.add(new Pair("Maharashtra", 20000));
        pq.add(new Pair("HP", 15500));
        pq.add(new Pair("UP", 80000));
        pq.add(new Pair("Goa", 70000));
        pq.add(new Pair("West Bengal", 90000));
        pq.add(new Pair("Punjab", 11000));
        pq.add(new Pair("J&K", 12000));


        //Search a state with maximum number of cases
        Pair top = pq.peek();
        System.out.println("Max state cases " + top.state + " " + top.cases);
        System.out.println();

        //sort
        while(pq.size() > 0)
        {
            Pair ans = pq.peek();
            System.out.println(ans.state + " " + ans.cases);
            pq.remove();
        }

        //HashMap<String, Integer> hs = new HashMap<>(pq);

        

    }
}
