//Iterators in java
//implement on Data Structure to iterate over them
//have two methods hasNext() and next()
//hides underlying details
//lazy evaluation- when iterating on a DS, it will not store everything in the memory, it will only cache the current 
// element
//dynamic ability of the underlying data- if data structure is modifies it should not afftect 

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

//implementing without iterator, it is also called eager evaluation, loading everything in the memory.

// class BSTIterator {
//     List<Integer> list;
//     int idx;
//     public BSTIterator(TreeNode root) {

//         this.list = new ArrayList<>();
//         this.idx = 0;
//         inorder(root);
//     }
//     private void inorder(TreeNode root){

//          if(root == null) return;

//          inorder(root.left);
//          list.add(root.val);
//          inorder(root.right);

//     }
//     public int next() {
//          return list.get(idx++);
        
//     }
    
//     public boolean hasNext() {
//         return idx < list.size();
        
//     }
// }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

//TC, SC - O(1)
class BSTIterator {
    Stack<TreeNode> st;
    
    public BSTIterator(TreeNode root) {
      this.st = new Stack<>();
      init(root);
    
    }

    private void init(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
         TreeNode temp = st.pop();
         
         init(temp.right);
         return temp.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
        
    }
}