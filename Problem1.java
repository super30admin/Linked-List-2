//Binary search tree iterator
// Time Complexity :O(n)
// Space Complexity :O(h) - Not Sure
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
Creating a stack for iterative inorder traversal of tree. Also to get the next element, created a linkedlist
of treeenode and stored all the node in the linkedlist
*/

import java.util.*;
public class Problem1 {
    Stack<TreeNode> st;
    LinkedList<TreeNode> ls;
    public static void main(String[] args){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        Problem1 p = new Problem1(root);
        int param_1 = p.next();
        System.out.println(param_1);
        boolean param_2 = p.hasNext();
        System.out.println(param_2);



    }
    public Problem1(TreeNode root) {
        st = new Stack<>();
        ls = new LinkedList<>();
        inorder(root);
    }
    public int next() {
        TreeNode res = ls.removeFirst();
        return res.val;
        
    }
    public boolean hasNext() {
        return !ls.isEmpty();
        
    }
    public void inorder(TreeNode root){
        if(root == null)
            return;
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            ls.addLast(root);
            //System.out.println(root.val);
            root = root.right;
        }
    }
    
}
