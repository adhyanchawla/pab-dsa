import java.util.*;

public class GTREEREV {
    
    public static class TreeNode{

        int data;
        ArrayList<TreeNode>children = new ArrayList<>();

        public TreeNode(int val)
        {
            this.data = val;
        }      
    }  

        public static void levelOrder(TreeNode root)
        {
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while(q.size() > 0)
            {
                TreeNode rm = q.remove();
                System.out.print(rm.data + " ");
                for(TreeNode child : rm.children)
                {
                    q.add(child);
                }
            }
        }

        public static TreeNode construct(int[] arr)
        {
            TreeNode root = new TreeNode(arr[0]);
            Stack<TreeNode> st = new Stack<>();
            st.push(root);
            for(int i = 1; i < arr.length; i++)
            {
                if(arr[i] != -1) 
                {
                    TreeNode nn = new TreeNode(arr[i]);
                    st.peek().children.add(nn);
                    st.push(nn); 
                }
                else
                {
                    st.pop();
                }
            }

            return root;
        }

        public static void traversals(TreeNode root)
        {
            System.out.println("Node Pre " + root.data);

            for(TreeNode child : root.children)
            {
                System.out.println("Edge Pre: " + root.data + " -- " + child.data);
                traversals(child);
                System.out.println("Edge Post: " + root.data + " -- " + child.data);
            }
            System.out.println("Node Post " + root.data);
        }

        public static void display(TreeNode root)
        {
            if(root == null)
                return;

            System.out.print(root.data + ": ");

            for(TreeNode child: root.children)
            {
                System.out.print(child.data + ", ");
            }

            System.out.println();
            
            for(TreeNode child: root.children)
            {
                display(child);
            }
        }

        public static void fun()
        {
            int [] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
            TreeNode root = construct(arr);
            levelOrder(root);
            //traversals(root);
            //display(root);
        }

        public static void main(String[] args)
        {
            fun();
        }

    }