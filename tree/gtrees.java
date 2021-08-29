import java.util.*;

public class gtrees {
    public static class GTree{
    public static class Node{
        int data;
        ArrayList<Node> children;

        Node(int data)
        {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }


    public Node constructTree(int[] data)
    {
        Stack<Node> st = new Stack<>();
        Node root = new Node(data[0]);
        st.push(root);

        for(int i = 1; i < data.length; i++)
        {
            if(data[i] != -1)
            {
                Node nn = new Node(data[i]);
                st.peek().children.add(nn);
                st.push(nn);
            }
            else{
                st.pop();
            }
        }

        return root;
    }

    public void display(Node root){
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0)
        {
            Node node = q.remove();
            System.out.print(node.data +" ");
            for(int i = 0; i < node.children.size(); i++)
            {
                q.add(node.children.get(i));
                //System.out.print(node.children.get(i).data + ", ");
            }           
            //System.out.println();
        }
    }

    public void display1(Node root){
        Stack<Node> q = new Stack<>();
        q.push(root);
        while(q.size() > 0)
        {
            Node node = q.pop();
            System.out.print(node.data +": ");
            for(int i = 0; i < node.children.size(); i++)
            {
                q.push(node.children.get(i));
                System.out.print(node.children.get(i).data + ", ");
            }           
            System.out.println();
        }
    }

    public void display2(Node root){
        // if(root == null)
        // return;

        System.out.print(root.data + ": ");
        for(int i = 0; i < root.children.size(); i++)
        {
            System.out.print(root.children.get(i).data + ", ");
            
        }
        System.out.println();

        // for(int i = 0; i < root.children.size(); i++)
        // {
        //     display2(root.children.get(i));
        // }
        for(Node child: root.children)
        {
            display2(child);
        }
    }

    public int size(Node root)
    {
        // if(root == null)
        // return 1;

        int count = 0;
        for(Node child: root.children)
        {
            count += size(child);
        }

        return 1 + count;
    }

    public static int maximum(Node root)
    {
        int max = -(int)1e9;
        for(Node child: root.children)
        {
            int recAns = maximum(child);
            max = Math.max(recAns, max);
            //max = Math.max(max, child.data);
        }

         return Math.max(max, root.data);
     }
     //wrt no of nodes
     public static int height(Node root)
     {
         int ht = 0;
         for(Node child: root.children)
         {
             int cht = height(child);
             ht = Math.max(ht, cht);
         }

         return ht + 1;
     }

     public static int minimum(Node root)
     {
         int min = (int)1e9;
         for(Node child : root.children)
         {
             min = Math.min(min, minimum(child));
         }

         if(min > root.data)
         return root.data;
         else return min;
     }

     public void displayLevelOrder(Node root)
     {
         Queue<Node> q = new ArrayDeque<>();
         q.add(root);

         while(q.size() > 0)
         {
            int sz = q.size();
            while(sz-- > 0)
            {
                Node rm = q.remove();
                System.out.print(rm.data + " ");
                for(Node child: rm.children)
                {
                    q.add(child);
                }
            }
        System.out.println();
         }
     }

     public void displayLevelOrder2(Node root)
     {
         Queue<Node> q1 = new ArrayDeque<>();
         Queue<Node> q2 = new ArrayDeque<>();
         q1.add(root);
         //System.out.print(root.data);   
         while(q1.size() > 0)
         {
            Node rm = q1.remove();
            System.out.print(rm.data + " ");
            
            for(Node child : rm.children)
            {
                q2.add(child);
            }
        
            if(q1.size() == 0)
            {
                System.out.println();
                q1 = q2;
                q2 = new ArrayDeque<>();
            }
        }
     }
     //marker method
     public static void displayLevelOrder3(Node root)
     {
         Queue<Node> q = new ArrayDeque<>();
         Node t = new Node(-(int)1e9);
         q.add(root);
         q.add(t);
         
         while(true)
         {
            Node rm = q.remove();
             if(rm == t)
             {  
                 System.out.println();
                 //q.add(t);
                 q.add(t);
             }
             else{
                
                System.out.print( rm.data + " ");
                
                for(Node child: rm.children)
                {
                     q.add(child);
                }
                //q.add(t);    
            }
            if(q.size() == 1){
                break;
            }
        }
     }

     public void printZigZag(Node root)
     {
         Stack<Node> st1 = new Stack<>();
         Stack<Node> st2 = new Stack<>();
         int lvl = 0;
         st1.push(root);
         while(st1.size() > 0)
         {
            if(lvl % 2 == 0)
            {
                while(st1.size() > 0){
                    Node rm = st1.pop();
                    System.out.print( rm.data + " ");
                    for(Node child: rm.children)
                    {
                        st2.push(child);
                    }
                }
                System.out.println();
                lvl++;
            }
            else if(lvl % 2 == 1)
            {
                while(st1.size() > 0){
                    Node rm = st1.pop();
                    System.out.print(rm.data + " ");
                    for(int i = rm.children.size()-1; i >= 0; i--)
                    {
                        st2.push(rm.children.get(i));
                    }
                }
                System.out.println();
                lvl++;
            }
            if(st1.size() == 0 && st2.size() > 0)
            {
                st1 = st2;
                st2 = new Stack<>();
            }
         }
     }

     public void mirror(Node root)
     {
         Queue<Node> q = new ArrayDeque<>();
         q.add(root);

         while(q.size() > 0)
         {
             Node rm = q.remove();
             int si = 0;
             int ei = rm.children.size()-1;
             while(si <= ei){
                swap(rm.children, si, ei);
                si++;
                ei--;
             }
             for(Node child : rm.children)
             q.add(child);
         }
     }

     public void removeLeaves(Node root)
     {
         for(int i = root.children.size()-1; i >= 0; i--)
         {
             Node child = root.children.get(i);
             if(child.children.size() == 0)
             {
                 root.children.remove(i);
             }
         }

         for(Node child : root.children)
         {
             removeLeaves(child);
         }
     }

     public void swap(ArrayList<Node> arr, int si, int ei)
     {
         Node t = arr.get(si);
         arr.set(si, arr.get(ei));
         arr.set(ei, t);
     }

     public Node getTail(Node node)
     {
         //Node temp = node;
         while(node.children.size() > 0)
         {
             node = node.children.get(0);
         }
         return node;
     }

     public void linearise(Node root)
     {
         for(Node child : root.children)
         {
             linearise(child);
         }

         for(int i = root.children.size()-2; i >= 0; i--)
         {
             Node slkitail = getTail(root.children.get(i));
             slkitail.children.add(root.children.get(i+1));
             root.children.remove(i+1);
         }

     }

     public Node linearise2(Node root)
     {
         if(root.children.size() == 0)
         return root;

         Node otail = linearise2(root.children.get(root.children.size()-1));

         for(int i = root.children.size()-2; i >= 0; i--)
         {
             Node slkitail = linearise2(root.children.get(i));
             slkitail.children.add(root.children.get(i+1));
             root.children.remove(i+1);
         }
         return otail;
     }

     public ArrayList<Integer> nodeToRootPath(Node root, int data)
     {
         if(root.data == data)
         {
             ArrayList<Integer> base = new ArrayList<>();
             base.add(root.data);
             return base;
         }
         for(int i = root.children.size()-1; i >= 0; i--)
         {
            ArrayList<Integer> recAns = nodeToRootPath(root.children.get(i), data);
            if(recAns.size() > 0)
            {
                recAns.add(root.data);
                return recAns;
            }
        }

        return new ArrayList<>();
     }

     public static class Pair{
         int ht; 
         int d;
     }

     public static Pair diameter(Node root)
     {
         Pair p = new Pair();
         int sdcht = -1;
         int dcht = -1;
         for(Node child : root.children)
         {
             Pair cp = diameter(child);
             int rht = cp.ht;
             p.d = Math.max(p.d, cp.d);

             if(rht > dcht)
             {
                 sdcht = dcht;
                 dcht = rht;
             }
             else{
                 sdcht = rht; 
             }
         }
         p.d = Math.max(p.d, dcht + sdcht + 2);
         p.ht = dcht + 1;
         return p;
     }
  
    public void fun(){
        int [] data = {10, 20, 50, -1, 60, -1, -1, 100, 70, -1, 80, 110, -1, 120, -1, -1, 90, 30, -1, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructTree(data);
        //printZigZag(root);
        //mirror(root);
        //removeLeaves(root);
        //linearise2(root);
        //display2(root);
        // ArrayList<Integer>ans = nodeToRootPath(root, 30);
        // for(int ele : ans)
        // {
        //     System.out.print(ele + " ");
        // }
        //System.out.println(height(root));
        Pair ans = diameter(root);
        System.out.println(ans.d);
    }
}

    public static void main(String[] args)
    {
        GTree g = new GTree();
        g.fun();
    }
    
}