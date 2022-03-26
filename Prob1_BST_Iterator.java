// Time Complexity : O(1) + O(H) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        traverse(root);
    }
    public void traverse(TreeNode root){
        while(root != null){ //Adding all the left nodes in stack 
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode temp = stack.pop(); //Popping top node and returning its value 
        traverse(temp.right); //Then call recursie call for curr top's right child
        
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}





