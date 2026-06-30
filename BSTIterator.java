// Time complexity: O(m+n)
// space complexity: O(m+n)
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        inorder(root);
    }

    private void inorder(TreeNode root) {

        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {

        TreeNode temp = stack.pop();
        inorder(temp.right);
        return temp.val;
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