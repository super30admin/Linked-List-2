// Time Complexity : Amortized O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        
        dfs(root);
    }
    
    public int next() {
        TreeNode next = stack.pop();
        dfs(next.right);
        return next.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void dfs(TreeNode root) {
        
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}