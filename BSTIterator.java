// Time Complexity : O(1) for both next() and hashNext() functions
// (next() worst case will be O(h) where h is th height of the tree)
// Space Complexity : NA
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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

        Stack<TreeNode> st ;

        public BSTIterator(TreeNode root) {
            st = new Stack<>();
            helper(root);
        }

        private void helper(TreeNode root){
            while(root != null){
                st.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = st.pop();
            helper(node.right);
            return node.val;
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


/*
TC: O(1) for both next() and hashNext() functions
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

class BSTIterator {
    ArrayList<Integer> li;
    int i;
    //System.out.println("value of i : " + i);

    public BSTIterator(TreeNode root) {
        li = new ArrayList<>();
        inorder(root);
    }

    private void inorder(TreeNode root){
        if(root == null)
            return;

        inorder(root.left);
        li.add(root.val);
        inorder(root.right);
    }

    public int next() {
        //System.out.println("next() - value of i : " + i);
        int ele = li.get(i);
        i++;
        //System.out.println("after inc : value of i : " + i);
        return ele;
    }

    public boolean hasNext() {
        return i!=li.size();
    }
}


 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

