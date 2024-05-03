// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        helper(root);
    }
    
    public void helper(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode re = st.pop();
        helper(re.right);
        return re.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
