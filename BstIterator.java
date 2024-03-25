import java.util.Stack;
//tc = o(1) for next and hasnext, o(n) worst for next
//sc = o(n) for stack
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        helper(root);
    }
    public void helper(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode pop = stack.pop();
        helper(pop.right);
        return pop.val;   
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */