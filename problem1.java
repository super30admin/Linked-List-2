//Time Complexity: O(1) for next() and hasNext() on average (amortized over all calls).For constructor - O(n) — due to full inorder traversal of the BST.
//Space Complexity: O(n) — stores all n node values from the BST in the list.

//Perform an inorder traversal of the BST and store all node values in a list.
//Maintain an index pointer to iterate through the list.
//Use next() to return the current value and increment the pointer; hasNext() checks bounds.

class BSTIterator {
    List<Integer> inorderList;
    int currentIndex;

    public BSTIterator(TreeNode root) {
        this.inorderList = new ArrayList<>();
        this.currentIndex = 0;
        performInorderTraversal(root);
    }

    private void performInorderTraversal(TreeNode currentNode) {
        if (currentNode == null) return;
        performInorderTraversal(currentNode.left);
        inorderList.add(currentNode.val);
        performInorderTraversal(currentNode.right);
    }

    public int next() {
        return inorderList.get(currentIndex++);
    }

    public boolean hasNext() {
        return currentIndex < inorderList.size();
    }
}
