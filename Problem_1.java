// Time Complexity : O(1) for next() and hasNext()
// Space Complexity : O(h), where h is height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use a stack to keep a track of inorder traversal. We push root and its left children. Then whenever next func
   is called we pop the topmost element. If it has a right child, we push it and its left children into the stack. hasnext() 
   func just checks if next element is there or not.
*/

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
        inorder(root);
    }
    
    public int next() {
        TreeNode root = st.pop();
        if(root.right != null)
            inorder(root.right);
        
        return root.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void inorder(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */