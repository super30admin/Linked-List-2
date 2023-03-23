/*
* Time Complexity - O(1) for constructor and hasNext()
                    O(n) for next().
* Space Complexity - O(n)
*/
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
    TreeNode root = null;
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        this.root = root;
    }
    
    public int next() {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        int retValue = root.val;
        root = root.right;
        return retValue;
    }
    
    public boolean hasNext() {
        if(!stack.isEmpty() || root != null)
            return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
