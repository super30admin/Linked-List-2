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
// Approach : Controlled Recursion
// Time : Ammotized O(1) for next function. 
// In Worst case : O(h) or O(n). 
//if it is skewed/Balanced Binary Search tree : O(log(n))
// Space : O(1) // Auxilary Space
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root); // add left-left... children
    }
    
    public int next() {
        TreeNode node = st.pop(); // remove from top of stack
        dfs(node.right); // process right
        return node.val; // node value
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
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