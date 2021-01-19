// Time Complexity : O(h) // for dfs
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class BSTIterator {

    Stack<TreeNode> stack;
    private void dfs(TreeNode root)
    {
        while(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
    }    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        
        TreeNode node = stack.pop();
        if(node.right!=null)
        {
            dfs(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        
        return !stack.isEmpty();
    }
}