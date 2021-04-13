/*
Thought Process: 
Element on the top initially will be left most node. SO we need to traverse left in a constructor to initialize a stack and fill elements in it.
The next function returns the top and then finds the right element and traverses to the left most of that element.

TC -> O(H) where H is the height of the tree whereas the average time complexity will be O(1)
SC -> O(H) wehre H is the height of the tree
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
class BinarySearchTreeIterator {
    Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root) {
        while(root!=null){
            this.s.add(root);
            root = root.left;
        }
    }
    
    public int next() {
        if(!hasNext()) return -1;
        TreeNode popped = this.s.pop();
        if(popped.right != null){
            TreeNode right = popped.right;
            while(right != null){
                s.push(right);
                right = right.left;
            }
        }
        return popped.val;
    }
    
    public boolean hasNext() {
        boolean res = this.s.isEmpty();
        if(res) return false;
        else return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */