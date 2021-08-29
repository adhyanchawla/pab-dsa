import java.util.*;

public class binarytreenew {
    
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

        public Node(int data)
        {
            this(data, null, null);
        }
    }

    public static void preOrder(Node node, ArrayList<Integer> ans)
    {
        if(node == null) return;

        ans.add(node.data);
        preOrder(node.left, ans);
        preOrder(node.right, ans);
    }

    public static void inOrder(Node node, ArrayList<Integer> ans)
    {
        if(node == null) return;

        inOrder(node.left, ans);
        ans.add(node.data);
        inOrder(node.right, ans);
    }

    public static void postOrder(Node node, ArrayList<Integer> ans)
    {
        if(node == null) return;

        postOrder(node.left, ans);
        postOrder(node.right, ans);
        ans.add(node.data);
    }

    public static boolean nodeToRootPath01(Node node, ArrayList<Node> ans, int data)
    {
        if(node == null)
        return false;

        if(node.data == data)
        {
            ans.add(node);
            return true;
        }

        boolean check = nodeToRootPath01(node.left, ans, data) || nodeToRootPath01(node.right, ans, data);
        if(check){
            ans.add(node);
        }

        return check;
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

        ArrayList<Node> lans = nodeToRootPath(node.left, data);
        if(lans.size() > 0){
            lans.add(node);
            return lans;
        }

        ArrayList<Node> rans = nodeToRootPath(node.right, data);
        if(rans.size() > 0){
            rans.add(node);
            return rans;
        }

        return new ArrayList<>();
    }

    public static void kLevelsDown(Node node, ArrayList<Node>ans, int k)
    {
        if(node == null || k < 0)
        return;

        if(k == 0)
        {
            ans.add(node);
            return;
        }

        kLevelsDown(node.left, ans, k-1);
        kLevelsDown(node.right, ans, k-1);
    }
}
