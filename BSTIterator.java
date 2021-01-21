// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class BSTIterator {

    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {

        dfs(root);
    }

    public int next() {
        //pop next element, and populating stack with next element
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }

    public boolean hasNext() {
        //if stack is not empty, can call next
        return !st.isEmpty();
    }

    public void dfs(TreeNode root){
        //go all the way to the left
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}
