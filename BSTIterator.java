/*
Time Complexity :
Worst case: O(n*h)
Average case: Amortized O(1)

In design problems, we look at the average case

 Space Complexity : O(n) stack space

 Did this code successfully run on Leetcode: Yes
 */

import java.util.Stack;

//Definition for a binary tree node.
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

class BSTIterator
{
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        init(root);
    }

    private void init(TreeNode root)
    {
        while(root != null)
        {
            st.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = st.pop();
        init(temp.right);
        return temp.val;
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
