// Time Complexity: O(2^n)
// Space Complexity: (n)

class BSTIterator {
Stack<TreeNode> s=new Stack<>();
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.right);
        s.push(root);
        inorder(root.left);
    }
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    public int next() {
        return s.pop().val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}
