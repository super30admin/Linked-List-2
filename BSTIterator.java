
/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<Integer> values;
    int index;

    public BSTIterator(TreeNode root) {
        values = new ArrayList<>();
        index = -1;
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }

    public int next() {
        ++index;
        return this.values.get(index);
    }

    public boolean hasNext() {
        if (index + 1 < values.size()) {
            return true;
        }
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
