// Time Complexity all functions: O(1)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
 /*
 We use stack to store the nodes. We use dfs to add all the left nodes from the root to the stack. 
 When next is called, it pops top node and stores all the left nodes on its right subtree.
 Has next checks if the stack is not empty. We use the concept of lazy loading in this logic.
 */
class BinarySearchTreeIterator {
    private Stack<TreeNode> stk;

    public BinarySearchTreeIterator(TreeNode root) {
        this.stk=new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root!=null){
            stk.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode n = stk.pop();
        dfs(n.right);
        return n.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
