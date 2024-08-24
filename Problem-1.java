// Time Complexity : O(h) + O(1) + O(1)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

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
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){ //O(h)
        while(root != null){
            stack.push(root);   //space O(h)
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode cur = stack.pop(); //O(1)
        dfs(cur.right); //O(h)worst //O(1)
        return cur.val;
    }
    
    public boolean hasNext() { //O(1)
        return !stack.isEmpty();
    }


    // public BSTIteratorBruteForce(TreeNode root) {
    //     list = new ArrayList<>();
    //     inorder(root);
    // }

    // private void inorderBruteForce(TreeNode root){
    //     if(root == null) return;
    //     inorder(root.left);
    //     list.add(root);
    //     inorder(root.right);
    // }
    
    // public int nextBruteForce() {
    //     return list.get(i++).val;
        
    // }
    
    // public boolean hasNextBruteForce() {
    //     return list.size() > i;
    // }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */