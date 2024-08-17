// Problem 173. Binary Search Tree Iterator
// Time Complexity : Constructor: O(H), next(): O(1), (amortized), O(H) (worst case), hasNext(): O(1)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }
    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    // O(1) O(1)
    public int next() {
        TreeNode curr = st.pop();
        dfs(curr.right); // O(H)
        return curr.val;
    }
    // O(1) O(1)
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
