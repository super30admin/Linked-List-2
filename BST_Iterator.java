// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack  = new Stack<>();
        dfs(root);
    }
    private void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode result = stack.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
