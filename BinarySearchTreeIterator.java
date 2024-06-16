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

// Time Complexity : next() - O(1) & hasNext() - O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using inorder DFS traversal. Started pushing elements from the root node till the leftmost node in the tree in the stack. Then next() will pop the element from the stack and check if it has valid right child, if yes start pushing. hasNext() which return false if stack is empty.
*/
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        pushElements(root);

    }

    //It will push the elements from the root till the leftmost
    private void pushElements(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode popped = s.pop();

        if(popped.right != null){
            pushElements(popped.right);
        }

        return popped.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */