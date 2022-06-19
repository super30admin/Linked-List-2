//space O(1)
//Time O(1)

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
    Stack<TreeNode> s = new Stack<>(); //  Create a new Stack for controlled recursion
    public BSTIterator(TreeNode root) {
        dfs(root);  // In the constructor , do a dfs on the root so that all its left children are added to the stack
    }
    private void dfs(TreeNode root)
    {
        while(root!=null)  // Perform dfs to add all the left children to stack
        { 
            s.add(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode curr= s.pop();  // Everytime iterator takes a next, we pop from the stack and do a dfs on its right so that those elements get added to the stack dynamically
        dfs(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();  // if stack not empty it means we still have next
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */