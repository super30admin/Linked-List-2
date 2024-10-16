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

    Stack<TreeNode> myStack;

    public BSTIterator(TreeNode root) {
        this.myStack = new Stack<TreeNode>();

        this.getLeftMostInorderTree(root);
    }
    
    public int next() {
        TreeNode top = myStack.pop();

        if(top.right!=null){
            this.getLeftMostInorderTree(top.right);
        }

        return top.val;

    }
    
    public boolean hasNext() {
        return !myStack.isEmpty();
    }

    public void getLeftMostInorderTree(TreeNode node){
        while(node!=null){
            this.myStack.push(node);
            node=node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

 //TC : O(n);
 //SC : O(h);