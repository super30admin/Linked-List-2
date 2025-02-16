// Time Complexity : O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/* If we perform inorder traversal on a list we get all elements in sorted order. We should not perform inorder traversal of complete tree. Instead we just store complete left subtree of the node and return the value when next() is called.
Whenever we pop() and return the value when next() is called we make sure to again traverse the left subtree. Thus mainting the inorder traversal ordering of nodes.
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

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {

        stack = new Stack<>();
        //We will store left side of tree in the stack
        TreeNode node = root;

        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
    //Time complexity: O(1) because in design we cal ammortized TC. And n/2 elements are leaf node which do not have right node. Then 25% of nodes only have 1 right node. Rem ones which have O(h) are very few nodes.
    public int next() {
        
        //Here we need to get next element
        TreeNode root = stack.pop();
        int val = root.val;

        //Now since we always return the value similar to inorder traversal
        //we go to right node and add all the left subtree
        root = root.right;

        while(root != null) {
            stack.push(root);
            root = root.left;
        }

        return val;
    }
    
    public boolean hasNext() {
        
        //we need to check if there is any next element, so if stack is empty that means no next element
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */