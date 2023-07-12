// tc : O(n)
// sc : O(n)

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
    private Stack<TreeNode> stack ;
    private Queue<Integer> q ; 
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        q = new LinkedList<>();
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode root){
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            q.add(root.val);
            root = root.right;
        }
    }
    
    public int next() {
        if( !q.isEmpty()) return q.poll();
        return -1;
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
