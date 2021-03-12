// Time Complexity :
Approach 1: Time complexity = O(no. of nodes in tree) for inorder traversal
Approach 2: Time complexity = O(1) in the best case when the tree does not
have right child


// Space Complexity :
Approach 1:Space complexity = o(n) as we define new ArrayList to flatten the BST
Approach 2:Space complexity = o(h) as at any pointe
the maximum size of stack is height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//Approach-1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BSTIterator {
    //Define a List to store the values in the tree which is then used to get next()
    List<Integer> tempList = new ArrayList<>(); 
    //pointer to iterate through list
    int p = 0;
    public BSTIterator(TreeNode root) {
       inorderTraversal(root); 
        
    }
    
    
    public int next() {
        return tempList.get(p++);
    }
    
    public boolean hasNext() {
        return p < tempList.size();
    }
    //Recursive inorder traversal
    private void inorderTraversal(TreeNode root){
        if(root == null) return;
        if(root.left != null) inorderTraversal(root.left);
        tempList.add(root.val);
        if(root.right != null) inorderTraversal(root.right);
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


 //Approach 2 Using stack and partial inorder traversal

 class BSTIterator {
    //To use O(h) memory we want to perform partial inorder traversal
    
    //Define a stack
     Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        //call the partial inorder traversal function
        partialTraversal(root);
    }
    
    //This is partial inorder traversal
    private void partialTraversal(TreeNode root){
        while(root != null){
            stack.add(root);
            root = root.left ;
        }
    }
    
    
    public int next() {
        //when next() function is called we will pop from the stack
        TreeNode node = stack.pop();
        /*Now we will check if there exists a right and if it exists we will call
        partial inorder traversal on right side of node before return the node
        */
        partialTraversal(node.right);
        
        return node.val;
        
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}