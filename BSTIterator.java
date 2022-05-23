// Time Complexity :O(1)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//we'll use a stack over the hood for controlled recursion.we have a dfs method which adds left nodes until 
//they become null.in hasnext method, we just need to check if stack is not empty, if stack is empty, we have no next
//in next, we'll return element at top of the stack and will call dfs method for right element as it is a BST

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode resultNode = st.pop();
        dfs(resultNode.right);
        return resultNode.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();

    }

    public void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        return;
    }
}
