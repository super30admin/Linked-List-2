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

//Time: O(1) for next() and hasNext()
//Space: O(h) - size of stack

class BSTIterator {

    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {

        this.st=new Stack<>();
        dfs(root); //func to go in depth to the left most nodes

    }
    private void dfs(TreeNode root){

        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    public int next() {
        TreeNode curr=st.pop();
        dfs(curr.right);
        return curr.val;
    }
    public boolean hasNext() {
        return (!st.isEmpty());
    }
}
