package LinkedList2;

//Implemented with the timeComplexities of next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree

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
public class BSTIterator {
    // Having the following code Commmented since an iterator and interface is implemented :
/**
 *  List<TreeNode> treeList;
 *     int currIndex = 0;
 *     public BSTIterator(TreeNode root) {
 *         treeList = new ArrayList<>();
 *         inorderTraversal(root, treeList);
 *
 *     }
 *
 *     public int next() {
 *         TreeNode currNode = treeList.get(currIndex);
 *         currIndex++;
 *         return currNode.val;
 *     }
 *
 *     public boolean hasNext() {
 *         return currIndex < treeList.size();
 *     }
 *
 *     public void inorderTraversal(TreeNode node, List<TreeNode> list) {
 *         if(node == null) {
 *             return;
 *         }
 *         inorderTraversal(node.left, list);
 *         list.add(node);
 *         inorderTraversal(node.right, list);
 *     }
 */

}
