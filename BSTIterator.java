
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class BSTIterator {
   Stack<TreeNode> stack;
   public BSTIterator(TreeNode root) {
      stack = new Stack<>();
       dfs(root);
   }
   
   public int next() {
       TreeNode result = stack.pop();
       dfs(result.right);
       return result.val;
   }
   
   public boolean hasNext() {
       return !stack.isEmpty();
   }
   
   private void dfs(TreeNode root){
       while(root!=null){
           stack.push(root);
           root = root.left;
       }
   }
}

/**
* Your BSTIterator object will be instantiated and called as such:
* BSTIterator obj = new BSTIterator(root);
* int param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/ {
    
}
