// Leetcode 173
// Time - O(1)
// Space - O(n)
class BSTIterator {
    
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        
        stack = new Stack();
        DFS(root);
    }
    
    public int next() {
        
        TreeNode top = stack.pop();
        
      
        DFS(top.right);
        
        return top.val;
    }
    
    public boolean hasNext() {
        
        return !stack.isEmpty();
    }
    
    private void DFS(TreeNode root){
        
        while(root!=null)
        {
          stack.push(root);
          root = root.left;
        }
    }
}