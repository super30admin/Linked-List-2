//The idea here is to try to implement lazy loading as much as possible and do it via controlled recursion by implementing what recursion does under the hood, over the hood using a stack.
//Time Complexity: Amortized O(1)
//Space Complexity: O(h), for the recursive stack space, where h is the height of the tree
import java.util.Stack;

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

   class BSTIterator {
       Stack<TreeNode> st;
       public BSTIterator(TreeNode root) {
           st = new Stack<>();
           dfs(root);
           
       }
   
       private void dfs(TreeNode root){
           while(root!=null){
               st.push(root);
               root = root.left;
           }
       }
       
       public int next() {
           TreeNode result = st.pop();
           dfs(result.right);
           return result.val;
       }
       
       public boolean hasNext() {
           return !st.isEmpty();
       }
   }