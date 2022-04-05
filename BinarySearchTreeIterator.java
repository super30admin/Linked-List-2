// Time Complexity : O(N), travering all nodes N, for tree construction; but next and HasNext has O(1) complexity
// Space Complexity : O(N) Extra list; here n are the nodes
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/674060245/) 
// Any problem you faced while coding this : No
// My Notes : Do the tree irorder traversal and store in a linkedlist. Remove the first node from the list as we added last

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

    LinkedList<Integer> list = null;
    // Create the linked list, using inorder stack traversal
    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            //System.out.println(node.val);
            list.addLast(node.val);
            root = node.right;
        }
        //System.out.println(list.size());
    }
    
    // Remove the first Node from the list.
    public int next() {
        return list.removeFirst();
        
    }
    
    // Check if the list size is greater than 0; else no node exists.
    public boolean hasNext() {
        return list.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */