import java.util.*;

public class binarytree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data, Node left, Node right)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Pair{
        Node n;
        int state;
        public Pair(Node n, int state)
        {
            this.n = n;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr)
    {
        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0], null, null);
        st.push(new Pair(root, 0));
    
        for(int i = 1; i < arr.length; i++)
        {
            Pair tos = st.peek();
            
            if(arr[i] == -1)
            {
                tos.state++;
                if(tos.state == 2)
                {
                    st.pop();
                }
            }
            else{
                Node nn = new Node(arr[i], null, null);
                if(tos.state == 0)
                {
                    tos.state = 1;
                    tos.n.left = nn;
                }
                else if(tos.state == 1)
                {
                    tos.n.right = nn;
                    st.pop();  
                }
                
                st.push(new Pair(nn, 0));
            }
        }
        return root;
    }

    public static int countLeavesOnlyChild(Node node)
    {
        if(node == null)
        return 0;
        
        int count = 0;
        count += countLeavesOnlyChild(node.left);
        count += countLeavesOnlyChild(node.right);

        if(node.left == null && node.right != null)
        count += 1;
        if(node.left != null && node.right == null)
        count += 1;
        return count;
    }

    public static void countLeavesOneChild(Node node, ArrayList<Integer> ans)
    {
        if(node == null)
        return;

        if(node.left == null && node.right != null)
        {
            ans.add(node.data);
        }
        if(node.left != null && node.right == null)
        {
            ans.add(node.data);
        }
        
        countLeavesOneChild(node.left, ans);        
        countLeavesOneChild(node.right, ans);
    }

    public static void display(Node root)
    {
        if(root.left != null)
        {
            System.out.print(root.left.data + " <--");
        }
        else{
            System.out.print("-1" + " <--");
        }
        
        if(root != null)
        System.out.print(root.data + " --> ");
        
    
        
        if(root.right != null)
        {
            System.out.print(root.right.data + " ");
        }
        else{
            System.out.print("-1" + " ");
        }

        System.out.println();

        if(root.left != null)
        display(root.left);
        if(root.right != null)
        display(root.right);
    }

    public static void main(String[] args)
    {
        Integer[] arr = {10, 20, 30, 40, 50, -1, -1, -1, -1, -1, -1};
        Node root = construct(arr);
        //display(root);
        System.out.println(countLeavesOnlyChild(root));
        // ArrayList<Integer> ans = new ArrayList<>();
        // countLeavesOneChild(root, ans);
        // for(int ele : ans)
        // {
        //     System.out.println(ele);
        // }
    }
}
