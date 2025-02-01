// Time Complexity: Amortized O(1) for next() and O(1) for hasNext()
// Space Complexity: O(1)
// where N is the number of nodes in the tree and h is the height of the tree

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

public class LC173 {

    TreeNode t;

    private TreeNode moveToNext() {
        TreeNode node = null;
        while (t != null && node == null) {
            if (t.left != null) {
                TreeNode tLeft = t.left;
                while (tLeft.right != null && tLeft.right != t) {
                    tLeft = tLeft.right;
                }
                if (tLeft.right == t) {
                    node = t;
                    t = t.right;
                } else {
                    tLeft.right = t;
                    t = t.left;
                }
            } else {
                node = t;
                t = t.right;
            }
        }
        return node;
    }

    public BSTIterator(TreeNode root) {
        this.t = root;
    }

    public int next() {
        return moveToNext().val;
    }

    public boolean hasNext() {
        return t != null;
    }
}