// --> H is the height of the tree.
// Time Complexity : O(1) - On average for returning the next element we push 1-2 elements. In worst case scenario we push H elements.
// Space Complexity : O(1) - At max we store H elements in the stack which can be considered of constant space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// 1. To implement this Iterator we do a controlled In order Traversal. 
// 2. Whenever we are asked to return an element, then we do a dfs on the right child of the popped node and push them into stack.
// 3. Repeat this process for all the nodes until the stack is empty.

import java.util.Stack;

public class BinarySearchTreeIterator {
    
    static Stack<TreeNode> st;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public BinarySearchTreeIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        // We pop the top element from the stack.
        // Value of the popped element will be returned.
        TreeNode result = st.pop();

        // Before returning the popped element, we do a dfs on the right child of the popped element.
        dfs(result.right);

        // return the nodes value.
        return result.val;
    }
    
    public boolean hasNext() {
        // check if the stack is empty or not. 
        // If the stack is empty then no more nodes exist to iterate. 
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root){
        // dfs on a given node, will push all the left child's recursively into stack.
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(12, new TreeNode(20), new TreeNode(22));
        root.left = left;
        root.right = right;

        BinarySearchTreeIterator obj = new BinarySearchTreeIterator(root);
        int param = obj.next();
        System.out.println(param);
        param = obj.next();
        System.out.println(param);
        param = obj.next();
        System.out.println(param);

        boolean param_2 = obj.hasNext();
        System.out.println(param_2);
    }
}
