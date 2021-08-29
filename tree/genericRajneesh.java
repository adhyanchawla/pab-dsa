import java.util.*;

public class genericRajneesh {
    
    public static class Node{
        int data;
        ArrayList<Node>children;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static int height(Node node)
    {

        int ht = -1;
        for(Node child : node.children)
        {
            int cht = height(child);
            ht = Math.max(cht, ht);
        }

        return ht + 1;
    }

    public static int size(Node node){

        int sz = 0;
        for(Node child : node.children)
        {
            sz += size(child);
        }

        return sz + 1;
    }

    public static boolean find(Node node, int data)
    {
        if(node == null)
        return false;

        if(node.data == data)
        {
            return true;
        }
        for(Node child: node.children)
        {
            boolean cans = find(child, data);
            if(cans) return true;
        }

        return false;
    }

    public static int sum(Node node)
    {
        int sm = 0;

        for(Node child : node.children)
        {
            sm += sum(child); 
        }

        return sm + node.data;
    }

    public static int maximum(Node node)
    {

        int mx = -(int)1e9;

        for(Node child : node.children)
        {
            int cmax = maximum(child);
            mx = Math.max(cmax, mx);
        }

        return Math.max(mx, node.data);
    }

    public static int minimum(Node node)
    {

        int min = (int)1e9;

        for(Node child : node.children)
        {
            int cmin = minimum(child);
            min = Math.min(cmin, min);
        }

        return Math.min(min, node.data);
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data)
    {
        if(node == null)
        return new ArrayList<>();

        if(node.data == data)
        {
            ArrayList<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }

        for(Node child : node.children)
        {
            ArrayList<Node> cans = nodeToRootPath(child, data);
            if(cans.size() > 0){
                cans.add(node);
                return cans;
            }
        }
        return new ArrayList<>();
    }

    public int countLeaves(Node node)
    {
        
        if(node.children.size() == 0)
        return 1;

        int count = 0;
        for(Node child : node.children)
        {
            count += countLeaves(child);
        }

        return count;
    }


}
