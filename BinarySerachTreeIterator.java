// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We use stack to implement this. When next() is called, we pop the top, return its value,
// and push its right child’s left path. hasNext() just checks if the stack is empty and return the boolean value.


class BSTIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root); //push to stack
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = st.pop();//pop the top
        dfs(temp.right); //right path
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty(); //check if stack is Empty
    }
}