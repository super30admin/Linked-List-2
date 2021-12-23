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

//Space complexity : o(n) - because we are mainting a seperate nodes array + o(h) for recursion stack
//Time complexity : o(n) - because we are visting each and every element of the nodes atleast once to put them in sorted array.
class BSTIterator {
    //Flatten treenode and store the elements in sorted array(inorder)
    List<Integer> nodes ;
    int index;

    public BSTIterator(TreeNode root) {
        nodes= new ArrayList<>();
        index=-1;
        inorder(root);
            
    }
    
    private void inorder(TreeNode root){
        if(root==null){return;}
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
        
    }
    
    //TC : o(1)
    public int next() {
        index++;
        return nodes.get(this.index);
    }
    
    //TC : o(1)
    public boolean hasNext() {
        return this.index+1<this.nodes.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */