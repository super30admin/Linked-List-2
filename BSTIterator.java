import java.util.Stack;

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

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        inorder(root);
    }
    
    private void inorder(TreeNode root){
      //  while(root!=null){
      //      stack.push(root);
      //      root = root.left;
      //  }
        if(root==null)
        return;
        stack.push(root);
        inorder(root.left);

    }
    public int next() {
        if(hasNext()){
        TreeNode temp = stack.pop();
        inorder(temp.right);
        return temp.val; 
        }
        return -1;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
