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
    /*
        TC - O(h) - constructor
            avg O(1) - next, hasNext
        SC - O(h)

        This solution implements a BST Iterator using a stack to perform an iterative inorder traversal.
        During initialization, push all the leftmost nodes from the root onto the stack.
        The top of the stack always represents the next smallest element in the BST.
        When next() is called:
        Pop the top node from the stack.
        If the popped node has a right child, push all the leftmost nodes of its right subtree onto the stack. 
        Return the popped node's value.
        hasNext() simply checks whether the stack is non-empty.
    */
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        inorder(root);
    }

    private void inorder(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode node = st.pop();
        inorder(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        if (st.size() > 0) {
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */