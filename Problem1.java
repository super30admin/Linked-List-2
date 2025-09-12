// Time Complexity : Amortized O(1)
// Space Complexity : O(h) - height of BST 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Using Iterative stack ie controlled recursion we achieve this
// Traverse to the left of the tree and add nodes into the stack
//when left node is empty and when next is called pop the topmost node in stack and process the right side of the tree 
// Has next checks if nodes present in stack if no return false

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
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode curr) {
        //process only left side and add nodes to stack
        while (curr != null) {
            st.add(curr);
            curr = curr.left;
        }
    }
    
    public int next() {
        TreeNode res = st.pop();
        //process the right side 
        dfs(res.right);
        return res.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty(); //check if stack still has nodes    
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
