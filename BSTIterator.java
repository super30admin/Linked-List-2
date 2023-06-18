// Time Complexity : The avg time complexity of next() and hasNext() both will be O(1)
// Space Complexity : O(1) as no extra space was used.
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.Stack;
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

    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode current = stack.pop();
        int currentValue = current.val;
        dfs(current.right);
        return currentValue;
    }
    public boolean hasNext() {
        return !stack.empty();
    }
    private void dfs(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */