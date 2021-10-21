// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//we want to traverse the BST in inorder that measn we go to left then root and then right so we make a function whi
//takes us to left of the tree. while doing this we keep pn strorinf the elements in the stack so that we can
//traverse them later. once we r at the deadend on left next() ives the element at top of the stack as thats the
//last element inserted and first element in inorder traversal. then we expose the second-top node
//this way once we finish the stack(that means we are done till root) we apply dfs on right side of the root
//whic again goes to leftmost part and it continues.


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
    Stack<TreeNode> stack=new Stack<TreeNode>();

  public BSTIterator(TreeNode root) { 
    
      dfs(root);
  }
  
  private void dfs(TreeNode root){
      
  while(root!=null){
      stack.push(root);
      root=root.left;
  }
  }
  
  public int next() {
      if(!hasNext()){
          return -1;
      }
      
      TreeNode root=stack.pop();
      dfs(root.right);
      
      return root.val;
      
  }
  
  public boolean hasNext() {
      return !stack.isEmpty();
  }
}

/**
* Your BSTIterator object will be instantiated and called as such:
* BSTIterator obj = new BSTIterator(root);
* int param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/