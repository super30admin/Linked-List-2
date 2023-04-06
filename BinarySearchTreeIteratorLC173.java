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

//Time Complexity: O(1)
//Space Complexity: O(n)
class BSTIterator {

    Stack<TreeNode> stack; //use stack for controlled recursion
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);              //calling the dfs method, to add all the left child of root inside a stack
        
    }
    
    private void dfs(TreeNode root){
        
        while(root!= null){     //add all the left child of the root node
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {         //pop the element from stack, and call the dfs method to the right side of that node to all the left child of that node
        TreeNode curr = stack.pop();
        dfs(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {  //check if stack is empty or not
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
