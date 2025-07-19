// Time Complexity: O(1)
// Space Complexity: O(H)

// We use a dfs method to traverse to the left most element. hasNext() return if the stack is not empty. next() pops the element, and we perform the same dfs on popped.right. It is a controlled recursion approach

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

    public static Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode popped = stack.pop();
        dfs(popped.right);
        return popped.val;

    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        stack.push(root);
        
        dfs(root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
