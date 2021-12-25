import java.util.Stack;

// Time Complexity : O(1), time complexity of constructor not taken in consideration
// Space Complexity : O(h) maximum nodes in a stack will be equal to height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class BSTIterator {

    // Definition for a binary tree node.
 public class TreeNode {
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

    //stack for controlled recursion 
        Stack<TreeNode> st;
        
    // Constructor Time complexity=O(n)
        public BSTIterator(TreeNode root) {
            st= new Stack<>();
            dfs(root);
        }
    
    // Time complexity is same as stack.pop() =O(1)
        public int next() {
            TreeNode popped= st.pop();
            dfs(popped.right);
            return popped.val;
        }
    
        
        public boolean hasNext() {
            return !st.isEmpty();
        }
        
        private void dfs(TreeNode root){
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