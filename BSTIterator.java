/**
 * Time Complexity - O(N) for next(), o(1) for hasNext, constructor.
 * Space Complexity - O(N) where N is the no of elements in the BST. 
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
