import java.util.*;

public class priorityqueue01{
    private ArrayList<Integer> data;
    
    public priorityqueue01()
    {
        data = new ArrayList<>();
    }

    public void add(int val)
    {
        data.add(val);
        upheapify(data.get(data.size()-1));
    }

    public void upheapify(int child)

    public int remove(){

    }

    public int peek(){

    }

    public int size(){
        return data.size();       
    }

}