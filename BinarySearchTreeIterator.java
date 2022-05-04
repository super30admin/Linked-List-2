// Time Complexity : next -> O(1)  hasNext -> O(1)
// Space Complexity : next -> O(h)  hasNext -> O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode result = stack.pop();
        dfs(result.right);
        return result.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
}
