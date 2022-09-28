// Time Complexity : O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1 - Controlled recursion - in normal inorder traversal, we do not have control over recursion.
 * 2 - we perform dfs until the point we reach the first element, then we stop the recursion, pop out
 *     the element and then perform dfs on the right.
 * 3 - hasNext() will check if the stack is empty or not
 * 4 - next() will pop out the element from the top of the stack
 */
//173. Binary Search Tree Iterator (Medium) - https://leetcode.com/problems/binary-search-tree-iterator/
 import java.util.Stack;

public class BSTiterator {
    Stack<TreeNode> st; 

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }

    public void dfs(TreeNode root){
        while(root != null)
        {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = st.pop();
        int temp = curr.val;
        dfs(curr.right);
        return temp;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}