// Time Complexity : BST iterator takes O(n), hasNext and next take O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    
    //lets maintain inorder traversal in a list
    ArrayList<Integer> inorderList;
    //and current index;
    int index;

    public BSTIterator(TreeNode root) {
        //initialize inorder list and index
        this.inorderList = new ArrayList<Integer>();
        
        this.index = -1;

        //process the node
        this._inorder(root);
    }
    
    //inorder traversal
    private void _inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        
        this._inorder(root.left);
        this.inorderList.add(root.val);
        this._inorder(root.right);
    }
    
    //return the node at (index+1) in the List
    public int next() {
        return this.inorderList.get(++this.index);
    }
    
    public boolean hasNext() {

        //check if the next index is within our saved inorder list
        return (this.index+1)<this.inorderList.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */