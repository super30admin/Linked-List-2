// https://leetcode.com/problems/binary-search-tree-iterator/description/
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

// Time Complexity: O(h)  Best case: O(1)
// Space Complexity: O(h) 
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }       
    }
    
    public int next() {
        TreeNode temp = stack.pop();
        TreeNode p = temp.right;
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        return temp.val;
    }
    
    public boolean hasNext() {
        return stack.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */