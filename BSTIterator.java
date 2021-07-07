// =================================== Controlled DFS ====================================================
/**
Time complexity: O(N)
Space: O(H) stack space
Algorithm:
=========
1. Push root's left nodes to stack initially till node is null
2. Whenever next is called, pop node from stack and push it's own right subtree nodes to stack
3. If stack is not empty, return true for hasNext as there are still nodes to be processed in BST
 */
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode p = root;
        controlledDFS(p);               // controlled DFS on root till node is null
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        controlledDFS(node.right);          // push right nodes to stack only when node is popped from stack
        return node.val;                    
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void controlledDFS(TreeNode node) {
        while(node != null) {
            stack.push(node);           // push node to stack
            node = node.left;           //iterate to left
        }
    }
}
// ====================================== Inorder traversal ================================================
/**
Time: O(N), space:O(N)
Algorithm:
=========
1. Use arraylist to store inorder of the tree
2. Use pointer to keep track of next() and hasNext() calls
 */
class BSTIterator {
    List<Integer> arr;                  // arraylist to store inorder
    int ptr;
    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        ptr = 0;
        inorder(root);
    }
    
    private void inorder(TreeNode root) {           //inorder of BST
        if(root == null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return arr.get(ptr++);                  // return next
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ptr != arr.size();           // return if already traversed the complete tree or not
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */