
// COnstructor takes o(n) space
// next and has next take O(1) space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;(
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
List<Integer> list;
int index;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.index = 0;
        dfs(root);
        
    }
    
    public int next() {
       if(hasNext()){
      return  list.get(index++);    }
      return -1;

    }

    private void dfs(TreeNode root){
          if(root == null) { return;}
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
        

    }
    
    public boolean hasNext() {
       return  index < list.size();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
