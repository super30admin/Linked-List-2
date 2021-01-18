// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Keep adding left child to stack. when it reaches left then pop one from stack and add its right child and 
// all of its left childs. 

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root != null){
            stack.add(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        node = node.right;
        while(node != null){
            stack.add(node);
            node = node.left;
        }
        return res;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}