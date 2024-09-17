/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//o(1) average time and o(n) time, o(height) space
    //passed all leetcode cases
    //used approach discussed in class
class BSTIterator {
    Stack<TreeNode> st;


    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        TreeNode p = root;
        dfs(p);

    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();

    }
    private void dfs(TreeNode node){
        while(node!=null){
            st.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */