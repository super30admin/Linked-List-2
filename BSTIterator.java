// Time Complexity : O(n) // Traverse all the Nodes
// Space Complexity : O(n) ( we are using a Arraylist that would contain all the elements of the tree in ascending order)
// Did this code successfully run on Leetcode : yes
/*Approach : next()- returns the smallest element in the binary tree. hastNext() - returns if there is an element present in the binary tree at
the next index position so, to find these we need to traverse the tree in inorder traversal way so that the elements can be arranged in the
ascending order and added to the list accordingly */


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
 List<Integer> ele;
     int index;
    public BSTIterator(TreeNode root) {
      ele = new ArrayList<Integer>();
      index = -1;
        if(root!=null)
            inorder(root);
    }
//time complexity O(1)
    public int next() {
        return ele.get(++index);
    }
//time complexity O(1)
    public boolean hasNext() {
        return index+1<ele.size();
    }
    private void inorder(TreeNode root){
        if(root==null)
            return;
       inorder(root.left);
        ele.add(root.val);
        inorder(root.right);


    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */