/* https://leetcode.com/problems/binary-search-tree-iterator/
173. Binary Search Tree Iterator - MEDIUM

Approach: An inorder traversal on a BST gives elements in ascending order. Inorder can be done both recursively and iteratively.
But, getting hold of the elements from the implicit recursion stack is not easy.
Use the iterative approach of inorder traversal.
At any point, the top of the stack has the smallest element. After the top element is removed,
the next smallest element will be the smallest element in its right subtree.
SC: O(h) - the stack holds only nodes equal to the height of the tree.
*/

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BSTIterator {
    Stack<TreeNode> st;
    BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        pushLeft(root);
    }

    /* The top of the stack. Push left children of right subtree.
    TC: average O(1) for n next operations
    */
    int next() {
        TreeNode next = st.pop();

        if (next.right != null) {
            pushLeft(next.right);
        }

        return next.val;
    }

    /* TC: O(1)
    */
    boolean hasNext() {
        return !st.isEmpty();
    }

    void pushLeft(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}

class Solution {
    public static void main(String args[]) {
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15, nine, twenty);
        TreeNode root = new TreeNode(7, three, fifteen);

        BSTIterator bstIterator = new BSTIterator(root);

        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}