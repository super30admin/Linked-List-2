// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.ArrayList;

class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<Integer> list;
    int cursor;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        cursor = 0;
        helper(root);
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        if (this.hasNext()) {
            return list.get(cursor++);
        } else
            return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cursor >= 0 && cursor < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */