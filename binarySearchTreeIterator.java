/**
TC: O(1)
SC: O(h) max size of stack is height h of tree. 
Approach: In stack, i keep storing the left node and keep traversing until i reach leftmost node. 
-> next(), i pop the stack and perform dfs on its right child where i will only do dfs on left part of the subtree. 
-> hasNext(): i will check if my stack is not empty then i will return true, else false.
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
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        this.s = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode curr = s.pop();

        dfs(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */