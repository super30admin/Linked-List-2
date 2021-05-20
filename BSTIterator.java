//using controlled recursion
//Time Complexity : O(1). In the worst case, if the tree is skweed tree, then all the nodes will be pushed in the stack at one time in the begining 
in the constructor which is called only once so it is O(1) and in other cases the nodes are pushed and poped  very soon so the O(h)(h is height of the tree)
 is amortized  or averaged to O(1).
//Space Complexity:O(h). h is the height of the tree
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        //push all the left nodes
        dfs(root);
    }
    
    public int next() {
        //if all the next() were not valid then write a condition for stack empty
        TreeNode deleted = stack.pop();
        //if this node has right child push it in the stack
        dfs(deleted.right);
        return deleted.val;
    }
    
    public boolean hasNext() {
        //if the stack is empty then there are no nodes
        return !stack.isEmpty();
    }
    //pushes all the left nodes
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        stack.push(root);
        dfs(root.left);
    }
}
