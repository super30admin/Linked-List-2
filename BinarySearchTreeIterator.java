// Time Complexity : next() -> O(H); hasNext() -> O(1)
// Space Complexity : next() -> O(H); hasNexxt() -> O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        if(!stack.isEmpty())
            return true;
        else
            return false;
    }
    
    private void dfs(TreeNode root){
        if(root == null)
            return;
        
        stack.push(root);
        dfs(root.left);
    }
}
