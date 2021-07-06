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
        st = new Stack();
        
        // go to left of the tree to get minimum
        
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        // pop element from the stack
        TreeNode topNode = st.pop();
        // when you remove the root node in any subtree, next pointer should be most left of right of the node if intially root has right child
        
        if(topNode.right != null ){
            // move to the left side
            TreeNode temp  = topNode.right;
            while(temp !=null) {
                st.push(temp);
                temp = temp.left;
            }
        }
        
        // return the topnode
        return topNode.val;
    }
    
    public boolean hasNext() {
        return st.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
