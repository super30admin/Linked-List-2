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
/*
time complexity: 
for next : O(1) in avg case and O(h) in worst case
for hasNext() : O(1)

space complexity :O (1)

*/
class BinaryTreeIterator {
    
    //stack is used to do dfs
    
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        
        //start dfs with root
        dfs(root);
    }
    
    public int next() {
        //whenever next is called, return the stack.top element and then start pushing right side of this subtree
        TreeNode result = stack.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
        
    }
    
    //push the nodes in stack until reaches left end of the tree
    private void dfs(TreeNode root){
        while(root != null){
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