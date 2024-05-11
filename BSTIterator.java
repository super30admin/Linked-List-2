// Time Complexity : amortized is O(1) and worst case is O(H) - height if the tree
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
class BSTIterator {
    List<Integer> li;
    int i;
    public BSTIterator(TreeNode root) {
        this.li = new ArrayList<>();
        this.i =0;
        inorder(root);
    }

    private void inorder(TreeNode root) {
        //base case
        if(root == null) return;

        inorder(root.left);
        li.add(root.val);
        inorder(root.right);

    }

    public int next() {
        return li.get(i++);
    }

    public boolean hasNext() {
        return i < li.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

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
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        init(root);
    }

    private void init(TreeNode root) {
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }


    public int next() {
        TreeNode curr = st.pop();
        init(curr.right);

        return curr.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */