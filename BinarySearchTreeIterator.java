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

/*
    Leetcode problem 173: Binary Search Tree Iterator
    T.C: O(n) :: S.C: O(h) - Amortized S.C

    Solved using DFS Approach: Traverse to the leftmost leaf node of the given root, while pushing
    each of the TreeNode to a stack. When next() is called, pop the element on top of the stack and 
    perform the same dfs operation on its right child (do not push if the TreeNode is null). For 
    the hasNext() method, return the negated true value of isEmpty() for the BSTIterator's stack data structure.
*/

class BSTIterator {
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);   
    }
    
    public int next() {
        TreeNode popped = s.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }

    private void dfs(TreeNode root) {
        while(root != null) {
            s.push(root);
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