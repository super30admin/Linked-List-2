//Time complexity: O(1) for next() and hasNext() average case, O(h) for best case for next() func, 
//O(N) for worst case
//Space complexity: O(1)
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.leftinorder(root);
    }
    
    private void leftinorder(TreeNode root) {
        while(root != null) {
           this.stack.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode top = this.stack.pop();
        if(top.right != null) {
            this.leftinorder(top.right);
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}
