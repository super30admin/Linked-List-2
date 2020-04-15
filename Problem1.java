/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity - O(n)
// Space Complexity - Without Recursive - O(1)
//                    With Recursive - O(maxdepth)
class BSTIterator {

    TreeNode start = null;
    TreeNode prev;
    public BSTIterator(TreeNode root) {
        convertToDoublyLinkedList(root);
    }

    private void convertToDoublyLinkedList(TreeNode root){

        if(root == null)
            return;

        convertToDoublyLinkedList(root.left);

        if(start == null){
            start = root;
            prev = root;
        }else{

        root.left = prev;
        prev.right = root;
        prev = root;

        }
        convertToDoublyLinkedList(root.right);
    }

    /** @return the next smallest number */
    public int next() {

        int val = start.val;
        start= start.right;;
        return val;
    }



    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return start != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */