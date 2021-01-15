// Time Complexity : The average time complexity of next() and hasNext() is O(1)
// Space Complexity : The space complexity is O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {

        leftTraversal(root);
    }

    // To traverse to the left most node
    public void leftTraversal(TreeNode root){

        while(root != null){
            stack.push(root);
            root=root.left;
        }
    }

    public int next() {

        TreeNode cur = stack.pop();

        // If the node has right children, then its left most node is the next smallest
        if(cur.right != null){
            leftTraversal(cur.right);
        }

        return cur.val;

    }

    public boolean hasNext() {

        return stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */