// Time Complexity : O(n)
// Space Complexity : O(n), storing in list
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : None.


public class BSTIterator {
    
    ArrayList<Integer> list = new ArrayList<Integer>(); 
    private int treeIdx;

    public BSTIterator(TreeNode root) {
        treeIdx = -1;
        inorder(root);
    }

    public int next() {
        return list.get(treeIdx++);
    }

    public boolean hasNext() {
        return treeIdx < list.size()-1;
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
        
        return;
    }
}
