// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//use stack and do controlled recursion instead of loading all nodes.

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        init(root);
    }

    private void init(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = st.pop();

        if (temp.right != null) {
            init(temp.right);
        }
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

     public static void main(String[] args) {
        // Constructing a sample binary search tree
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Creating a BSTIterator
        BSTIterator iterator = new BSTIterator(root);

        // Print values using the iterator
        System.out.println("BST Iterator Example:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}


