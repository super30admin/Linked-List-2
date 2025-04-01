import java.util.Stack;

import javax.swing.tree.TreeNode;

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
//Overal Time Complexity: 
//DFS: O(h) where h is height of the tree. For skewed trees it is O(n)
//next(): O(1) amortized
//hasNext(): O(1)
//Overall Space Complexity is O(h) = height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation

// Do DFS on the root and move towards the leftmost node until we hit the leaf node so that we simulate inorder traversal
 // Use stack to store the treenodes 
 // When next is called pop the top node from the stack , perform dfs again to move right and return the popped val(root)
// The hasNext checks whether the stack is empty or not to infrom that there are elements to process.

class BSTIterator {

    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);

        
    }
    public void dfs(TreeNode root) {
        while(root!=null){
            st.push(root);
            root = root.left;
        }

    }
    public int next() {
        if(!st.isEmpty()){
            TreeNode popped = st.pop();
            dfs(popped.right);
            return popped.val;
        }
        return 0;
        

    }
    
    public boolean hasNext() {
        if(!st.isEmpty()){
            return true;
        }
        return false;
}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */