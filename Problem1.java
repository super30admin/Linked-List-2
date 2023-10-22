// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class BSTIterator {
    Stack<TreeNode> stk;
    private void dfs(TreeNode root){
        while(root!= null){
            stk.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode curr = stk.pop();
        dfs(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}
