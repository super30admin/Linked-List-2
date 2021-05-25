// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


//Time Complexity: O(n) since we are iterating through all the nodes of the tree
//Space Complexity: O(n) since we are using extra stack
class BSTIterator {
    public Stack<TreeNode> stack;
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
    
    private void dfs(TreeNode left){
        while(left != null){
            stack.push(left);
            left = left.left;
        }
    }    
}
