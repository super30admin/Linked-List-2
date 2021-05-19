/* Approach: 
1. In the constructor itself, traverse the left side of the tree and store the left nodes in the stack. So we will have left nodes of the main root present in the stack.
2. We are essentially performing the inorder traversal. But the traversal is controlled.
3. We only process the other elements that were not added to the stack when the next function is called.

Time complexity: Worst case: O(H), else O(1)
space complexity: O(H)
*/
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        inorder(root); 
    }
    
    public int next() {
        TreeNode root = stack.pop();
        inorder(root.right);
        return root.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void inorder(TreeNode root)
    {
        if(root==null)
            return;
        while(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */