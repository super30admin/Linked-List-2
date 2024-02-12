// Time - O(n)
// Space - O(h)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root = root;
          st.add(root);
          advance(root);
    }
    
    public int next() { 
        if(hasNext()){
            TreeNode root1 = st.pop();
            if(root1.right!=null){
                st.push(root1.right);
                advance(root1.right);
            }
            return root1.val;
        }
        return -1;
        
    }
    
    public boolean hasNext() {
        if(st.isEmpty()){
            return false;
        }
        return true;
        
    }

    public void advance(TreeNode root){
        while(root.left!=null){
            st.push(root.left);
            root=root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
