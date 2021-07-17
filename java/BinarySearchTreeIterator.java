// Time Complexity : O(1)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
It is inorder traversal  with controlled recursion where you store first path in constructor
        and next small paths one at a time in a stack and pop the top element when next() is called as the least element would be on top.
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
        controlledDfs(root);
    }

    private void controlledDfs(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = stack.pop();
        if(curr.right!=null){
            controlledDfs(curr.right);
        }
        return curr.val;
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