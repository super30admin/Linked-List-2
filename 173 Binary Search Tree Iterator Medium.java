//173 Binary Search Tree Iterator Medium.java
//https://leetcode.com/problems/binary-search-tree-iterator/
//https://github.com/super30admin/Linked-List-2
//Time Complexit:O(n)
//Space Complexit:O(n) //NORMAL BST


//SPace Complexit:O(log n) //RED BLACK TREE i.e Balance BST 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    Stack<TreeNode> myStack= new Stack<>();
    
    public BSTIterator(TreeNode root) {
        process(root);
    }
    
    
    /** @return the next smallest number */
    public int next() {
        //check if stack is empty
        
        TreeNode temp = myStack.peek();
        myStack.pop();
        if(temp.right != null)
            process(temp.right);
        return temp.val;
    }
    
    public void process(TreeNode tempRoot){
        if(tempRoot == null)
            return;
        myStack.push(tempRoot);
        if(tempRoot.left != null){
            process(tempRoot.left);
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !myStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */