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
//Use a stack. Put all the left element in stack
//When next is called, get left elements of right node by calling dfs using curr node.right. Return curr.val
// Check whether stack is empty or not
//TC:O(1)-->amortized; SC:O(h) [h is height of tree]
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack=new Stack<>();
        dfs(root);
    }
    
    public int next() {
        if(!(stack.isEmpty())){
            TreeNode curr=stack.pop();
            dfs(curr.right);
            return curr.val;

        }

        return -1;
    }

    private void dfs(TreeNode curr){
        if(curr==null){
            return;
        }
        stack.add(curr);
        dfs(curr.left);
    }
    
    public boolean hasNext() {
        return !(stack.isEmpty());
        
    }
}
