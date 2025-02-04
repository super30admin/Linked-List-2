// Time Complexity : 1) Init: O (n) 2) next: O (1) 3) hasNext: O (1)
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

// Just store the InOrder traversal in a list and iterate over this
// using an index
public class BSTIterator {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    List<Integer> inOrder = new ArrayList<>();
    int i;

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        inOrder.add(node.val);
        inOrderTraversal(node.right);
    }

    public BSTIterator(TreeNode root) {
        inOrderTraversal(root);
        i = -1;
    }

    public int next() {
        return inOrder.get(++i);
    }

    public boolean hasNext() {
        return i + 1 < inOrder.size();
    }
}
