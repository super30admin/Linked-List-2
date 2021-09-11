/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BSTIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        inorder(root);
    }

    public int next() {
        TreeNode result = st.pop();
        inorder(result.right);
        return result.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void inorder(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}
// TC: O(1) SC: O(1)

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */