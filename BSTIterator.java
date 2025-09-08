//time complexity O(1) amortized(for both next and hasnext)
//space complexity O(h) h is the height of the tree (stack space)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

/**
 * The intuition behind this approach is to use an own stack as we wish to do a lazy evaluation since it is an iterator.
 * So we push all the left nodes of the tree to the stack and when we call next we pop the topmost element and call helper function on its right child if it exists.
 * When the right child exists we again push all its left nodes to the stack after which we return the popped element.
 * When we call hasNext we just check if the stack is empty or not.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.Stack;
class BSTIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {

        this.st=new Stack<>();
        helper(root);
        
    }

    private void helper(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }

    }
    
    public int next() {

        TreeNode temp=st.pop();
        helper(temp.right);
        return temp.val;
        
    }
    
    public boolean hasNext() {

        return !st.isEmpty();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */