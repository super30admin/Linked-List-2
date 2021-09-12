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
// Time Complexity: In average case the we are just pushing or popping the element from stack. In worst case it is O(h)
// Space Complexity: O(h) Stack of height of tree is stored.
// Did you complete it on leetcode: Yes
// Any problems faced: No, understood in lecture.

// Write your approach here:
// Idea here is to perform controlled recursion by using a stack
// while creating constructor: we are adding roots to stack and moving left
// to perform next we just need to pop the top most element as it will be left of root
// if left is popped right is checked of that node and if not found root will be popped
// before iterating through right of root.
// hasNext will specify true if there are any elements remaining in stack.
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result = stack.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public void dfs(TreeNode root) {
        while(root !=null){
            stack.push(root);
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