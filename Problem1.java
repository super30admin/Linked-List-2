// 173. Binary Search Tree Iterator

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
        s = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode findnext = s.pop();
        if(findnext.right != null){
            dfs(findnext.right);
        }
        return findnext.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    private void dfs(TreeNode root){
        while(root != null){
            s.push(root);
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


/*
Complexity Analysis
Time complexity: This is clearly a linear time operation i.e. O(N) in the worst case.
Space complexity: The space complexity is 
O(N) - N is the number of nodes in the tree, which is occupied by our custom stack for simulating the inorder traversal.
*/