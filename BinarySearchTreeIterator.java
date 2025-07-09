// Time Complexity: - next(): Amortized O(1), Each node is pushed and popped from the stack once.
//                  - hasNext(): O(1)
// Space Complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - using a stack.
// - On initialization, we push all the leftmost nodes from root into the stack using the dfs().
// - The next() method pops the top node from the stack, which is the current smallest element.
//   - Then, we call dfs() on its right child to add the next set of left descendants.
// - hasNext() checks if the stack is non-empty.

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
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        //Call dfs to put all the left nodes in the stack
        dfs(root);
    }

    //Puts current and all the left nodes in the stack
    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        //Get the node on the top of the stack
        TreeNode temp = st.pop();
        //Before returning it, call dfs again for its right baby
        //It and All its left babies will be added into the stack
        dfs(temp.right);
        //Return the temp value
        return temp.val;
    }

    public boolean hasNext() {
        //If stack is not empty we have next element
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */