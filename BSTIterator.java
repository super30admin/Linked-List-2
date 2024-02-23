// Time Complexity : O(1), amortized TC will be O(1) as n/2 and n/4 nodes at leaf and leaf-1 level will have TC : O(1).
//infrequently we would be adding h elements in the stack
// Space Complexity : O(1), if we only take user functions into account else O(h) for the custom stack we build
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english :In order to achieve the lazy loading, we did control recursion and only focused
//on the next element rather than the whole tree. We built a custom stack to mimic recurssion in a controlled way.

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
        this.st = new Stack<>();
        helper(root);
    }

    //add all the left nodes to the root
    private void helper(TreeNode root){
        if(root == null) return;

        st.add(root);
        helper(root.left);
    }
    
    public int next() {
        if(hasNext()){
            TreeNode e = st.pop(); //controlled recursion
            helper(e.right); // move right
            return e.val;
        }
        else{
            return 0; // dummy condition as all calls will be valid
        }
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */