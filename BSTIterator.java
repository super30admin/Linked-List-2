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
Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
      st = new Stack<>();
        dfs(root);
    }
    
    private void dfs(TreeNode root){
        while(root!= null){
            st.push(root);
            root= root.left;
        }
    }
    
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
       if(st.isEmpty()== false) return true;
        else return false;
    }
}

//Time Complexity -O(n)
//Space complexity- O(n)

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */