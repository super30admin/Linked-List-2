// Time Complexity : next() operation O(h) in worst case where h is height of bst, but average case is O(1). hasNext() is O(1)
// Space Complexity : O(h) where h is height of the bst
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class BST_Iterator{
    public static void main(String[] args) {

    }
}

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        //dfs puts all TreeNodes onto the stack
        dfs(root);
    }
    
    public int next() {
        if(hasNext()){
            //next node is on top of the stack
            // after poping the next element, add all the nodes to it's left
            TreeNode curr = st.pop();
            dfs(curr.right);
            return curr.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        //if stack is empty that means there is no node to iterate
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root){
        //put all the nodes till left most node
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
}
