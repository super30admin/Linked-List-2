/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
 //Time complexity:O(N)
 //Space complexity: O(N)
class BSTIterator {

    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator(TreeNode root) {

      
        this.nodesSorted = new ArrayList<Integer>();

       
        this.index = -1;

      
        this._inorder(root);
    }

    private void _inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        this._inorder(root.left);
        this.nodesSorted.add(root.val);
        this._inorder(root.right);
    }


    public int next() {
        return this.nodesSorted.get(++this.index);
    }

 
    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}