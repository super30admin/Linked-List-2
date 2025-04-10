// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach
class BSTIterator {

    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
        
    }

    private void dfs(TreeNode root) {
        while(root!=null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() { 
        TreeNode temp = st.pop();
        dfs(temp.right);
        return temp.val;
    }

    public boolean hasNext() { //O(1)
        return !st.isEmpty();
    }
    
}