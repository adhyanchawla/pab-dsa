import java.util.*;

public class BTREEREV {

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node()
        {

        }
        public Node(int data, Node left, Node right)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Pair{
        Node root;
        int state;
        public Pair(Node root, int state)
        {
            this.root = root;
            this.state = state;
        }
    }

    public static Node construct(int[] arr)
    {
        Node root = new Node(arr[0], null, null);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        for(int i = 1; i < arr.length; i++)
        {
            Pair tos = st.peek();
            if(arr[i] == -1)
            {
                tos.state++;
                if(tos.state == 2)
                st.pop();
            }
            else{
                Node nn = new Node(arr[i], null, null);
                if(tos.state == 0)
                {
                    tos.state = 1;
                    tos.root.left = nn;
                }
                else if(tos.state == 1)
                {
                    tos.state = 2;
                    tos.root.right = nn;
                    st.pop();
                }
                st.push(new Pair(nn, 0));
            }
        }
        return root;
    }

    public static void display(Node root)
    {
        if(root.left != null)
        System.out.print(root.left.data + " <--");
        else System.out.print(0 + " <--");

        if(root != null)
        System.out.print(root.data + " --> ");
        
        if(root.right != null)
        System.out.print(root.right.data);
        else System.out.print(0);
        System.out.println();

        if(root.left != null)
        display(root.left);
        if(root.right != null)
        display(root.right);

    }


    public static void fun()
    {
        int[] arr = {10, 20, 40, -1, -1, 50, 80, -1, -1, -1, 30, 60, -1, 90, -1, -1, 70, -1, -1};
        Node root = construct(arr);
        display(root);
    }

    public static void main(String[] args)
    {
        fun();
    }
    
}
