// Time Complexity :O(1) --> on an average as we will be checking it particular left node has right child
// Space Complexity :O(H) --> We are storing left most elements in Stack (tranversing height only)
// Did this code successfully run on GeeksforGeeksEditor : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class BSTIterator {
    
    Stack<TreeNode> storeNodes;
    public BSTIterator(TreeNode root) {
        this.storeNodes = new Stack<>();
        this.inorderLeftMost(root);
        
    }
    
    public void inorderLeftMost(TreeNode root){
        //keep push left most elements
        while(root != null){
            this.storeNodes.push(root);
            root = root.left;
        }
        
    }
    
    public int next() {
        TreeNode topStackNode = this.storeNodes.pop();
        if(topStackNode.right != null){
            this.inorderLeftMost(topStackNode.right);
        }
       return topStackNode.val;
    }
    
    public boolean hasNext() {
        if(!storeNodes.isEmpty())
            return true;
        return false;
       
        
    }
}