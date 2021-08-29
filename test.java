import java.util.*;

public class test{
    class Solution {
        public boolean isEvenOddTree(TreeNode root) 
        {
            if(root == null)
                return false;
            Queue<TreeNode> que = new ArrayDeque<>();
            que.add(root);
            int lvl = 0;
            boolean flag = false;
            TreeNode t = new TreeNode();
            while(que.size() > 0)
            {
                if(lvl % 2 == 0)
                {
                    int rm = que.size();
                    while(rm >= 2)
                    {
                        flag = false;
                        TreeNode r = que.remove();
                        t = r;
                        rm--;
                        if(r.val % 2 == 1 && r.left != null)
                        {
                            if(r.left.val % 2 == 0)
                            que.add(r.left);   
                            else return false;
                        }
                        if(r.val % 2 == 1 && r.right != null)
                        {
                            if(r.right.val % 2 == 0)
                            que.add(r.right);   
                            else return false;
                        }
                        if(rm >= 2){
                            TreeNode r1 = que.remove();
                            t = r1;
                            rm--;
                        if(r1.val % 2 == 1 && r1.left != null)
                        {
                            if(r1.left.val % 2 == 0)
                            que.add(r1.left);   
                            else return false;
                        }
                        if(r1.val % 2 == 1 && r1.right != null)
                        {
                            if(r1.right.val % 2 == 0)
                            que.add(r1.right);   
                            else return false;
                        }
                        if(r.val % 2 == 1 && r1.val % 2 == 1 && r.val < r1.val)
                        {
                            flag = true;
                        }
                            else return false;
                        }
                    }
                    if(flag == true && rm == 1)
                    {
                        TreeNode n = que.remove();
                        if(n.val % 2 == 1 && n.val > t.val)
                        {
                            if(n.left != null)
                            {
                               if(n.left.val % 2 == 0)
                                que.add(n.left);   
                                else return false; 
                            }
                            if(n.right != null)
                            {
                                if(n.right.val % 2 == 0)
                                que.add(n.right);   
                                else return false;
                            }
                        }
        
                        
                        
                        else return false;
                    }
                    if(rm == 1)
                    {
                        TreeNode rt = que.remove();
                        if(rt.val % 2 == 0){
                        if(rt.left != null)
                        {
                            if(rt.left.val % 2 == 0)
                                que.add(rt.left);
                            else return false;
                        }
                        if(rt.right != null)
                        {
                            if(rt.right.val % 2 == 0)
                                que.add(rt.right);
                            else return false;
                        } 
                    }
                    lvl++;
                }
                
                if(lvl % 2 == 1)
                {
                    int rm = que.size();
                    while(rm >= 2)
                    {
                        flag = false;
                        TreeNode r = que.remove();
                        t = r;
                        rm--;
                        if(r.val % 2 == 0 && r.left != null)
                        {
                            if(r.left.val % 2 == 1)
                            que.add(r.left);   
                            else return false;
                        }
                        if(r.val % 2 == 0 && r.right != null)
                        {
                            if(r.right.val % 2 == 1)
                            que.add(r.right);   
                            else return false;
                        }
                        if(rm >= 2){
                            TreeNode r1 = que.remove();
                            t = r1;
                            rm--;
                        if(r1.val % 2 == 1 && r1.left != null)
                        {
                            if(r1.left.val % 2 == 1)
                            que.add(r1.left);   
                            else return false;
                        }
                        if(r.val % 2 == 1 && r.right != null)
                        {
                            if(r1.right.val % 2 == 1)
                            que.add(r1.right);   
                            else return false;
                        }
                        if(r.val % 2 == 0 && r1.val % 2 == 0 && r.val > r1.val)
                        {
                            flag = true;
                        }
                            else return false;
                        }
                    }
                    if(flag == true && rm == 1)
                    {
                        TreeNode n = que.remove();
                        if(n.val % 2 == 0 && n.val > t.val)
                        {
                            if(n.left != null)
                            {
                               if(n.left.val % 2 == 1)
                                que.add(n.left);   
                                else return false; 
                            }
                            if(n.right != null)
                            {
                                if(n.right.val % 2 == 1)
                                que.add(n.right);   
                                else return false;
                            }
                        }
                        else return false;
                    }
                    if(rm == 1)
                    {
                        TreeNode rt = que.remove();
                        if(rt.val % 2 == 0){
                        if(rt.left != null)
                        {
                            if(rt.left.val % 2 == 1)
                                que.add(rt.left);
                            else return false;
                        }
                        if(rt.right != null)
                        {
                            if(rt.right.val % 2 == 1)
                                que.add(rt.right);
                            else return false;
                        }    
                    }
                    lvl++;
                }
            }
                    return true;
            }
            
        }
    }
    }
}