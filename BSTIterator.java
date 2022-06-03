// Time Complexity :worst case O(logn) - avg case O(1) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class BSTIterator {
    TreeNode cur;
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        this.cur = root;

        s = new Stack<>();
        while (cur.left != null) {
            s.push(cur);
            cur = cur.left;
        }
    }

    public int next() {
        if (cur == null) {
            return -1;
        }

        int temp = cur.val;

        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                s.push(cur);
                cur = cur.left;
            }
        } else if (!s.isEmpty()) {
            cur = s.pop();
        } else {
            cur = null;
        }
        return temp;
    }

    public boolean hasNext() {
        if (cur != null)
            return true;

        if (!s.isEmpty())
            return true;

        return false;
    }

}
