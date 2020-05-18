//Time Complexity : O(1) (next operation)
                    //O(1)(Has next operation)
                    //O(h) Setting up the iterator (first left traversal)

//Space Complexity : O(h) size of the stack
//Runs successfully on leetcode
//No Problem

//Here at the time of setting up the iterator , we will be traversing to left leaf noode
//At the time of removal, we will be calling the same operation (left leaf node traversal) on the removed node

import java.util.Stack;

public class Linked_List_2_Problem_2_bstIterator {
    Stack<TreeNode> st;
    public Linked_List_2_Problem_2_bstIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        dfs(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode element = st.pop();
        dfs(element.right);
        return element.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void dfs(TreeNode root)
    {
        if(root == null) return;
        st.add(root);
        dfs(root.left);
    }
}
