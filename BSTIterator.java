// Approach: Traverse and store the inorder traversal of the given BST in an array while constructing the iterator object. Maintain a
// global index to track the next element to return. In the hasNext method, return whether this index is within the inorder array length.
// In the next method, return the element at the current index and increment the index.
// Time Complexity: O(1)
// Space Complexity: O(n) where n - node count
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/binary-search-tree-iterator/description/

import java.util.List;
import java.util.ArrayList;

public class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }

    int i;
    List<Integer> inorder;

    public BSTIterator(TreeNode root) {
        i = 0;
        inorder = new ArrayList<>();
        traverse(root, inorder);
    }

    public int next() {
        return inorder.get(i++);
    }

    public boolean hasNext() {
        return i < inorder.size();
    }

    void traverse(TreeNode root, List<Integer> in) {
        if (root == null) {
            return;
        }
        traverse(root.left, in);
        in.add(root.val);
        traverse(root.right, in);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bsti = new BSTIterator(root);

        System.out.println("Iterating through given BST in inorder fashion..");
        while (bsti.hasNext()) {
            System.out.print(bsti.next() + " ");
        }
        System.out.println();
    }
}