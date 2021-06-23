import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(1)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class BSTIterator {
    List<Integer> res = new ArrayList<>();
    int i;

    public BSTIterator(TreeNode root) {
        helper(root);
        this.i = -1;
    }

    void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }

    public int next() {
        i++;
        return res.get(i);
    }

    public boolean hasNext() {
        if (i + 1 < res.size()) return true;
        return false;
    }
}
