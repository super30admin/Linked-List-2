import java.util.*;

// O(1) average time, O(h) space
class BSTIterator {
    List<Integer> list;
    int idx;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        idx = 0;
        helper(root);
    }
    
    public int next() {
        int val = list.get(idx);
        idx++;
        return val;
    }
    
    public boolean hasNext() {
        return idx < list.size();
    }

    private void helper(TreeNode root) { // inorder traversal
        if (root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}