// Time Complexity : O(1)
// Space Complexity : O(h) -- height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class BSTIterator {
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        addNodes(root, st);
        
    }
    
    public int next() {
        TreeNode smallest = st.pop();
        addNodes(smallest.right, st);
        return smallest.val;
        
    }
    
    public boolean hasNext() {
        return st.size() != 0;
        
    }
    public void addNodes(TreeNode root, Stack<TreeNode> stack){
        while(root != null) {
            stack.push(root);
            root=root.left;
        }
        
    }
}