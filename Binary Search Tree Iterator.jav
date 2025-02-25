class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftmostNodes(root);
    }

    public int next() {
        TreeNode node = stack.pop(); 
        if (node.right != null) {
            pushLeftmostNodes(node.right); 
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeftmostNodes(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/*
Time Complexity:
- next(): O(1) on average. Each node is pushed and popped exactly once.
- hasNext(): O(1) since it only checks if the stack is non-empty.
- Overall: O(n) for n nodes, but each operation is O(1) amortized.

Space Complexity:
- O(h), where h is the height of the BST (log n for balanced BST, n for skewed BST).
*/
