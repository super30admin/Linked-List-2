import java.util.Stack;

//Time Complexity : O(1) 
//Space Complexity :Oh1)
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

class BSTIterator {

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        dfs(root);
    }
    
    public void dfs(TreeNode root){
       while(root!=null){
           stack.push(root);
           root = root.left;
       }
    }
    
    public int next() {
         TreeNode temp = stack.pop();
        dfs(temp.right);
        return temp.val;
        
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}