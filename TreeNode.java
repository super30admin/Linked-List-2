import java.util.Stack;

/**
 * Definition for a binary tree node.
*/

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

// Did this code successfully run on Leetcode : Yes
// Space Complexity : O(h)
class BSTIterator {
    Stack<TreeNode> stack;

    private void traverse(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        traverse(root);
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        traverse(curr.right);

        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */