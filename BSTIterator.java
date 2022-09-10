// Space complexity: O(N)
// Correct optimized approach - We perform a controlled recursion. To perform a controlled recursion we use an iterative inorder approach using our own stack. We cannot use a recursive approach as we won't have control over the stack. This approach is the right way to implement an iterator because let's say if the tree is changed or a node is added or removed, this iterator will still work. // Iterator is supposed to be dynamic and should just care about the next node and nothing else and should not be affected
// by addition or removal of nodes in the rest of the tree and should be able to still work. In this approach we are controlling
// the stack.

class BSTIterator {
    
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        inorderHelper(root);
    }
    
    private void inorderHelper(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() { // O(h) in worst case, O(1) avg case. O(1) avg case as most of the nodes are leaf nodes in the tree and they require constant time. The upper nodes will have O(h) in the recursive stack. So O(1) avg, O(h) worst case
        TreeNode topMost = stack.pop();
        inorderHelper(topMost.right);
        return topMost.val;
    }
    
    public boolean hasNext() { // O(1)
        return stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */