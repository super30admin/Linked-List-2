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
 * Time Complexity : Amortised O(1) for next(). The next has complexity of N over a period of N operation
 this means the amortised.
 Space Complexity : O(H) H is height of tree. so worst case it will be O(N).  
 */
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode popped = stack.pop();
        if(popped.right != null){
            dfs(popped.right);
        }
        return popped.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public void dfs(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */