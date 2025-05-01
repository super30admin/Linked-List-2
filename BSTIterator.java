
//Time Complexity: O(n)
//Space Complexity: O(n)


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


public class BSTIterator {


        Stack<TreeNode> st;
        public BSTIterator(TreeNode root) {
            st = new Stack<>();
            dfs(root);
        }

        public int next() {
            TreeNode popped = st.pop();
            TreeNode node =  popped.right;
            dfs(node);
            return popped.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        public void dfs(TreeNode root){
            while(root != null){
                st.push(root);
                root = root.left;
            }
        }

}
