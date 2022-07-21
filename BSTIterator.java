// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = st.pop();
        int temp = curr.val;
        dfs(curr.right);
        return temp;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
} 