// Time Complexity - O(1) - not sure
// Space Complexity - O(1) - not sure

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
    public BSTIterator(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode root){
        while(root!=null){
            st.push(root);
            System.out.println(root.val);
            root = root.left;
        }
        
    }
    
    public int next() {
        // if(st.isEmpty()) return null;
        TreeNode result = st.pop();
        // System.out.println(result.val);
        helper(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        if(st.isEmpty()) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */