// Time Complexity : O(n) where n = number of nodes in the tree
// Space Complexity : O(n) where n = number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    
    List<Integer> inOrderNodes;
    int currindex;

    // Initialise inOrderNodes list, currindex and call inorder traversal function
    public BSTIterator(TreeNode root) {
        inOrderNodes = new ArrayList<Integer>();
        currindex = -1;
        inorder(root);
    }
    
    // In-order traversal
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inOrderNodes.add(root.val);
        inorder(root.right);
    }
    
    // return the next number from inOrderNodes list
    public int next() {
        return inOrderNodes.get(++currindex);
    }
    
    // check if the next number exists in inOrderNodes list
    public boolean hasNext() {
        return currindex + 1 < inOrderNodes.size();
    }
}

public class Problem1 {
    
    public static TreeNode makeTree(Integer[] arr) {
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                nodes[i] = new TreeNode(arr[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                int left = 2*i+1 - 2*count;
                if (left >= nodes.length) {
                    break;
                }
                nodes[i].left = nodes[left];

                int right = left+1;
                if (right >= nodes.length) {
                    break;
                }
                nodes[i].right = nodes[right];
            } else {
                count++;
            }
        }
        return nodes[0];
    }

    // Function to print the binary tree
    public static void printTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
          return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                res.add(null);      
            } else {
                q.add(curr.left);
                q.add(curr.right);
                res.add(curr.val);
          }
        }
        int i = res.size()-1;
        while (res.get(i) == null) {
            res.remove(i--);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Integer[] levelarr = {7, 3, 15, null, null, 9, 20};
        TreeNode root = makeTree(levelarr);
        // printTree(root);
        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
    }


}
