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

// approach- we use an external stack.
// the idea behind the iterator is to create dynamicity.
// It is used in all production cases.(check out the libraries in java)
// So, we maintain external stack and we push inside the stack.

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    // put the left nodes in the stack.
    private void dfs(TreeNode root) {// Amortized = O(1). since half the nodes are having the time complexity dfs() as O(1).
        // and we always consider the amortized time complexity as time complexity.
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    // pop the root node, and check the right children.
    public int next() {
        TreeNode root = stack.pop();
        dfs(root.right);
        return root.val;        
    }
    
    // Check whether the stack is empty.
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