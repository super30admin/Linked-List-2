// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
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
    
    public int next() { //O(H)
        TreeNode node = st.pop(); //first pop the curr node from stack
        dfs(node.right); //then go it right and add the element in the stack
        return node.val; //return its value
    }
    
    public boolean hasNext() { //O(1)
        
        return !st.isEmpty(); //returning T/F whether next element in the stack is empty of not

    }
    
    public void dfs(TreeNode root){ 
        while(root != null){
            st.push(root); //performing dfs on left of tree from root and pushing elements in stack
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