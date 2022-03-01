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
    
    Stack<TreeNode> stack = new Stack<>();

    // TC - O(N) where N is the height of left most tree.
    // SC - O(N) where N is the height of left most tree. 
    public BSTIterator(TreeNode root) {
      traverseAllTheWayLeft(root);
    }
    
    private void traverseAllTheWayLeft(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        
        stack.push(root);
        traverseAllTheWayLeft(root.left);
    }
    
    // TC - O(N) for traversing the next successor of the current tree node to make that available for next operation.
    // SC - O(h) height of the tree in the worst case when tree has only right nodes.
    public int next() {
        
        if (!stack.isEmpty())
        {
            TreeNode pop = stack.pop();
            traverseAllTheWayLeft(pop.right);
            return pop.val;
        }
        
        return -1;
    }
    
    // TC - O(1)
    // SC - O(1)
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
