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

class BSTIterator {
    Stack<TreeNode> st; //we need the reference.
    public BSTIterator(TreeNode root) {
        this.st = new Stack<TreeNode>();
        helper(root);
    }
    
    private void helper(TreeNode root)
    {
        while(root != null)
        {
            st.push(root);
            root = root.left;
        }
    }
    public int next() { //O(h) worst case   ~O(1) [Average]
        TreeNode re = st.pop();
        helper(re.right);

        return re.val;       
    }
    
    public boolean hasNext() { //O(1)
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */