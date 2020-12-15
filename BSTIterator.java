// Time Complexity : O(1) -> hasNext
//                 : O(N) -> next
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
class BSTIterator {
    /*
    Definition for a binary tree node.
    */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    Stack < TreeNode > s;
    public BSTIterator(TreeNode root) {
        s = new Stack < > ();
        dfs(root);
    }

    public int next() {
        TreeNode popped = s.pop();
        if (popped.right != null) {
            dfs(popped.right);
        }
        return popped.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
    public void dfs(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }
}