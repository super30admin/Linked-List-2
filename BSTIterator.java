/**
Problem : BST Iterator
Did it run on LeetCode: Yes

Time Complexity : O(n), where n is the number of nodes
Space Complexity : O(h), where h is the height of the tree

Approach:
1. The next element in the BST Iterator, can be derived from the inorder traversal of the tree.
2. We do a depth-first search traversal of the tree for finding the next element. (the next element would be the top of the stack)
3. To know if the tree has next element or not, we see if the stack is empty or not.
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
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode root = st.pop();
        dfs(root.right);
        return root.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    public void dfs(TreeNode root) {
        while(root!=null) {
            st.push(root);
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