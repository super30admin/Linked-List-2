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

/* Time Complexity :
     init(): O(h),
     next(): Worst(O(h)), Best/Average(O(1)),
     hasNext() : O(1)*/
/**
 * TC for next() is O(1) because 50% of the nodes are leaf nodes which won't have right subtree. Another 25% are 1 level above which
 * will have just 1 node in right subtree. Hence 75% of the nodes will have O(1) TC.
 */
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * init(): Initially, store traverse and store all nodes until root.left is null. For next(), pop from the stack and check if it has
 * right subtree. If yes, then call init(). For hasNext(), if stack is empty, return false else true.
 */
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        init(root);
    }

    private void init(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if(node.right != null)
            init(node.right);
        return node.val;
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