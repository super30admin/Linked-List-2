// Time Complexity : O(N) ~ N is the number of nodes
// Space Complexity : O(h) ~ h is the height of the tree and only those many nodes will be stored in a stack at a particular time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Initially, I used a list and stored the nodes in it by iterating it in inorder but that defeats the purpose of an iterator
I used my own stack to control recursion in which I populated all the left nodes first.
While popping out in next() method, I populated the left nodes from the popped element's right node
*/


import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Problem1 {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        st.add(root);
        inorder(root.left);
    }
    
    public int next() {
        TreeNode ele = st.pop();
        inorder(ele.right);
        return ele.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
