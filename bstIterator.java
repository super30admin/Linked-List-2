//Time Complexity:O(1) amortized for next()
//Space Complexity:O(h)
//executed on leetcode: yes
/**approach: next() : pop the element from stack if popped element has right again go to left of it like previously
hasNext() : we just have to check whether the stack is empty or not */
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

    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    Stack<TreeNode> stk = new Stack<>();
    /** @return the next smallest number */
    public int next() {
        TreeNode result = stk.pop();
        dfs(result.right);
        return result.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }
    private void dfs(TreeNode root){
        while(root!= null){
            stk.push(root);
            root= root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */