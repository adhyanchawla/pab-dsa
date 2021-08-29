import java.util.LinkedList;
import java.util.ArrayList;
//hashmap construction
//hashmap : searching efficient: we make a grp
// formula pehle se bna hua hai jiss grouping hoti hai
// maksat yeh hai ki reduce the collisions

//steps of construction
//make node class first
//then make data members
//then initialize func (constructor)
//getHashcode func 
//getGroup
//containsKey
//get
//remove
//getOrDefault
//put
//putIfAbsent
//display
//keyset
//Rehash

//why cant we maintain the order?

//contradicting factors
//bucketLength
//rehash
//group size
//hashcode (unique)

public class hashmap01 {
    
    private class Node{
        Integer key = null;
        Integer value = null;

        //  ListNode next = null;
        // hum bani bnayi ll use krenge
        private Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }
    //Data Members==========================================
    
    private LinkedList<Node>[] Buckets;
    private int bucketLen = 0;
    private int TotalNoOfNodes = 0;

    //Constructor===========================================

    private void initialize(int size){
        bucketLen = size;
        Buckets = new LinkedList[size];

        for(int i = 0; i < size; i++){
            Buckets[i] = new LinkedList<>();
        }

        TotalNoOfNodes = 0;
    }

    public hashmap01(){
        initialize(10);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int tempSize = this.TotalNoOfNodes;
        for(int i = 0; i < this.bucketLen; i++){
            LinkedList<Node> group = this.Buckets[i];
            int size = group.size();
            while(size-->0){
                Node node = group.removeFirst();
                sb.append(node.key + "=" + node.value);
                group.addLast(node);


                if(--tempSize != 0)
                {
                    sb.append(",");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    //Basic functions=======================================

    public int size(){
        return this.TotalNoOfNodes;
    }

    public boolean isEmpty(){
        return this.TotalNoOfNodes == 0;
    }

    //Exceptions============================================


    //DS Functions==========================================

    public ArrayList<Integer> keySet(){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < this.bucketLen; i++){
            LinkedList<Node> group = this.Buckets[i];
            int size = group.size();
            while(size-->0){
                Node node = group.removeFirst();
                ans.add(node.key);
                group.addLast(node);
            }
        }
        return ans;
    }


    public void putIfAbsent(Integer key, Integer defaultValue){
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);
        if(!res){
            Node node = new Node(key, defaultValue);
            group.addLast(node);
            this.TotalNoOfNodes++;
        }
    }
     
    public Integer getOrDefault(Integer key, Integer defaultValue){
        Integer val = get(key);
        return val != null ? val : defaultValue;
    }
    
    public void put(Integer key, Integer value){
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);

        if(res){
            group.getFirst().value = value;
        } else{
            Node node = new Node(key, value);
            group.addLast(node);
            this.TotalNoOfNodes++;
            
            double lambda = group.size()/ (1.0 * this.bucketLen); 
        
            if(lambda > 0.4){
                rehash();
            }
        }
    }

    private void rehash(){
        LinkedList<Node>[] temp = Buckets;
        initialize((int)(this.bucketLen * 1.5));

        for(int i = 0; i < temp.length; i++){
            LinkedList<Node> group = temp[i];
            int size = group.size();
            while(size-->0){
                Node node = group.removeFirst();
                put(node.key, node.value);
            }
        }
    }

    public Integer get(Integer key){
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);
        if(res){
            return group.getFirst().value;
        } else{
            return null;
        }                
    }

    public Integer remove(Integer key){
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);

        if(res){
            this.TotalNoOfNodes--;
            return group.removeFirst().value;
        }

        return null;
    }

    public boolean containsKey(Integer key){
        LinkedList<Node> group = getGroup(key);
        int gs = group.size();
        boolean res = false;
        while(gs-->0){
            //O(1)
            if(group.getFirst().key.equals(key)){
                res = true;
                break;
            }
            //O(1)
            group.addLast(group.removeFirst());
        }

        return res;
    }

    private LinkedList<Node> getGroup(Integer key){
        int hc = getHashCode(key);
        return Buckets[hc];
    }

    //jo result niklta hai woh hota hai hashcode
    //yeh func hashcode generate krta hai
    private int getHashCode(Integer key){
        return Math.abs(key.hashCode()) % bucketLen;
    }
}
