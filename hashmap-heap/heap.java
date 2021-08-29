import java.util.*;

public class heap {
    
    //Data Members===========================================================================================

    private ArrayList<Integer> arr;
    private int noOfElements = 0;
    private boolean isMaxHeap = true;

    
    //Constructor============================================================================================

    private void initialize(boolean isMaxHeap) {
        this.arr = new ArrayList<>();
        this.noOfElements = 0;
        this.isMaxHeap = isMaxHeap;
    }

    public heap(boolean isMaxHeap){
        initialize(isMaxHeap);
    }

    //constuctor chaining
    public heap(){
        this(true);
    }

    //O(n)
    public heap(int[] data, boolean isMaxHeap){
        this(isMaxHeap);

        for(int ele : data){
            this.arr.add(ele);
        }

        this.noOfElements = this.arr.size();

        for(int i = this.arr.size()-1; i >= 0; i--){
            downHeapify(i);
        }
    }

    //Basic Functions============================================================================================

    public int compareTo(int t, int o){
        if(isMaxHeap){
            return this.arr.get(t) - this.arr.get(o);
        } else{
            return this.arr.get(o) - this.arr.get(t);
        }
    }

    private void swap(int i, int j){
        int e1 = arr.get(i);
        int e2 = arr.get(j);

        arr.set(i, e2);
        arr.set(j , e1);
    }

    //O(logN)
    private void downHeapify(int maxIdx){
        int pi = maxIdx, lci = 2 * pi + 1, rci = 2 * pi + 2;

        if(lci < this.arr.size() && compareTo(lci, maxIdx) > 0){
            maxIdx = lci;
        }

        if(rci < this.arr.size() && compareTo(rci, maxIdx) > 0){
            maxIdx = rci;
        }

        if(pi != maxIdx){
            swap(maxIdx, pi);
            downHeapify(maxIdx);
        }
    }

    //O(logN)
    private void upheapify(int idx){
        int ci = idx;
        int pi = (ci - 1)/2;

        if(pi >= 0 && compareTo(ci, pi) > 0){
            swap(ci, pi);
            upheapify(pi);
        }
    }

    //Exception Handling=======================================================================================

    public void heapUnderFlowException() throws Exception {
        if(this.noOfElements == 0){
            throw new Exception("heapUnderFlowException");
        }
    }

    //DS functions=============================================================================================

    public void add(int data){
        this.arr.add(ele);
        this.noOfElements++;
        upheapify(this.noOfElements-1);
    }

    public int remove(){
        heapUnderFlowException();
        
        int ele = this.arr.get(0);
        swap(0, this.arr.size()-1);
        this.arr.remove(this.arr.size()-1);
        
        downHeapify(0);
        this.noOfElements--;

        return ele;
    }

    public int size(){
        return noOfElements;
    }

    public boolean isEmpty(){
        return noOfElements == 0;
    }

    public int peek() throws Exception{
        heapUnderFlowException();
        return this.arr.get(0);
    }

}
