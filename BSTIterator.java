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


    /*
1. Store all the nodes in a linkedlist through constructor.
2. use this list to iterator methods.
*/
    
    LinkedList<Integer> l;
    Stack<TreeNode>  st;

    public BSTIterator(TreeNode root) {
        l = new LinkedList<>();
        st = new Stack<TreeNode>();      
        while(root != null || !st.empty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            l.addLast(root.val);
            root = root.right;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        return l.pollFirst();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(l.peekFirst() != null){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
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
// Time Complexity : Constructor -         O(Height of tree )
//                   next(), hasNext() -   O(1)
// Space Complexity : O(Height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1. Use usual iterative method, push till left most node in constructor
2. in next method, whenever popping, push the right subtree as well.
*/
    
    Stack<TreeNode>  st;

    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();      
           dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
            TreeNode root = st.pop();
            int ans = root.val;
            root = root.right;
            dfs(root);
            return ans;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!st.empty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void dfs(TreeNode root){
         while(root != null){
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