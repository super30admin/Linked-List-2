/** Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST)
* next and hasNext is O(1) and SC O(h) where h is height of the tree
*
*/

class BSTIterator {
    Stack<TreeNode> s = new Stack<>();
    public BSTIterator(TreeNode root) {
        if (root == null)
            return;
        dfs(root);
    }
    
    public int next() {
        TreeNode popped = s.pop();
        if (popped.right != null)
        {
            dfs(popped.right);
        }
        return popped.val;
    }
    
    public boolean hasNext() {
        return (!s.isEmpty());
    }
    
    private void dfs(TreeNode root) {
        while(root != null) {
            s.add(root);
            root = root.left;
        }
    }
}

