// Time Complexity :  next - O(n*h) hasNext : O(1)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach - we 
//are using a stack to control the recursion

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        init(root);
    }

    public void init(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }

    }   

    public int next() { //O(N*H) 
        TreeNode tmp = stack.pop();
        init(tmp.right);
        return tmp.val;
    }
    
    public boolean hasNext() { //O(1)
        return !stack.isEmpty();
    }
}
