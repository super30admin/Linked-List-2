// Time Complexity : O(1)
// Why O(1) :: In this case we are ignoring the ops in Constructor
// hasNext () -> O(1)
// next() -> O(1) pops the element in stack + amortized O(1) inorder movement in Complete tree since we already reached till leaf in our Initialization 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class BSTIterator {

    Stack<TreeNode> st;

    private void left_traversal(TreeNode root) {

        if (root == null) return;

        while (root != null) {
            this.st.add(root);
            root = root.left;
        }

        // collected all the left nodes in stack

    }

    public BSTIterator(TreeNode root) {

        if (root == null) return;

        // In the constructor we will Initialize our stack
        this.st = new Stack<>();

        // Go to the extreme left till the last node and add the values to stack
        // Initialization
        while (root != null) {
            st.add(root);
            root = root.left;
        }

    }

    public int next() {

        // After Initialization we will be at null
        TreeNode node = st.pop();

        // If right side node is present and it is not null
        // Move Right by one node and Go to the extreme Left :: This is Controlled Inorder using Stack
        if (node.right != null) {
            left_traversal(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}