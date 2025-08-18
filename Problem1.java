// Time Complexity :O(1)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// we implement an in-order traversal using a stack to achieve lazy evaluation
//push all the left elements in stack, 
// when next() is called, we pop from the stack and and push its right child’s left path

class BSTIterator {
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        this.stk=new Stack<>();
        helper(root);
    }
    
    public int next() {
        TreeNode temp=stk.pop();
        helper(temp.right);
        return temp.val;
    }
    
    private void helper(TreeNode root){
        while(root!=null){
            stk.push(root);
            root=root.left;
        }
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}
