// Time complexity:- O(n)
// Space complexity:- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * This problem is about implementing an iterator for the in-order traversal of a binary search tree (BST). 
 * I used a recursive in-order traversal to store the values of the BST in a list. 
 * The next() method returns the next element by incrementing an index, while hasNext() checks if there are more elements to traverse. 
 */ 
class BSTIterator {
    // List to store the in-order traversal of the BST
    private List<Integer> result;
    int idx; // Index to keep track of the current position in the in-order list

    // Initializes the iterator with the in-order traversal of the BST.
    public BSTIterator(TreeNode root) { // O(n)
        this.result = new ArrayList<>();
        inorder(root);
    }
    // Helper method to perform an in-order traversal of the tree
    private void inorder(TreeNode node) {
        //base
        if(node == null) {
            return;
        }

        // Recurse on the left subtree to visit all nodes in left subtree before current node
        inorder(node.left);

        // Process the current node: Add its value to the result list
        result.add(node.val);
        System.out.print(node.val+ ", ");

        // Recurse on the right subtree 
        inorder(node.right);
    }
    
    //
    public int next() { // O(1)
        int re = result.get(idx);
        idx++;
        return re;
    }
    // Returns whether there are more elements in the traversal
    public boolean hasNext() { // O(1)
        return idx != result.size();
    }
}
