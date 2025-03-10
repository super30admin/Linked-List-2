// Time Complexity : Amortized O(1) because 75% of nodes doesn't have right subtrees. but for the root node the controlled recrusion takes O(h) where h is the height of the tree.
// Space Complexity : O(h) where h is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.*;
class TreeNode {
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
class BSTIterator {
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root)
    {
       while(root != null)
        {
            stk.add(root);
            root = root.left;
        }
        
    }
    public int next() {
        TreeNode node = stk.pop();
        dfs(node.right);
        return node.val;
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