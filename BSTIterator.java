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

    LinkedList<Integer> list;
    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        populateList(root);
    }
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(n)
    // Performing Inorder traversal to populate the linkedlist
    private void populateList(TreeNode root){
        if(root == null)
            return;
        populateList(root.left);
        list.add(root.val);
        populateList(root.right);
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // Since the linkedlist is inorder traversal of tree - the first node pf the linked list would be the smallest node
    public int next() {
        return list.size() > 0 ? list.removeFirst() : 0;
    }
    
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // If linked list contains elements then true else false
    public boolean hasNext() {
        return list.size() > 0 ? true : false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */