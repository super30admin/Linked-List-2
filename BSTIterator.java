// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


class BSTIterator {
    
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;    
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        
        stack.push(root);
        dfs(root.left);
    }
}