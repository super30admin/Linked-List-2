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
        dfs(root);
    }
    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    public int next() {
       TreeNode node = st.pop();
       dfs(node.right);
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




 /**
 TC - O(n), travelling to all the nodes.
 SC - O(n), Using Stack
 Approach : 

 Iterator is dynamic when compared with arrays. In Iterator we will got by each node when next() is called. hasNext() is used to check whether stack is empty or not.  Going left till root == null. Poping out top most element inside stack and going root.right. Going towards left if there is any left node existes. If not then calling next() function.  
 
  */