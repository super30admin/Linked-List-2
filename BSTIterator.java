// Time Complexity : next() -> amortized O(1), hasNext() -> O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Maintain an external stack. When initalizing the Iterator do a DFS and push all elements into stack
// next -> pop top element, before returning, do a DFS of its right child and push to stack
// hasNext -> check if stack is empty

class BSTIterator {
    Stack<TreeNode> st;

    private void DFS(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        DFS(root);
    }
    
    public int next() {
        TreeNode temp = st.pop();
        DFS(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}