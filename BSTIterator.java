// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* 
 * BST iterators are only bothered about the next value and don't care about the rest of the value till we reach that point.
 * We create a stack to keep track of the current node.
 * we insert in the stack till we reach null to the left of the root node, we call the recursive call to the right node only after we remove the current node.
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

    private Stack<TreeNode> stack ;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();

        dfs(root);
    }

    private void dfs(TreeNode root)
    {
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode top = stack.pop();

        dfs(top.right);

        return top.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */