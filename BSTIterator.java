// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use a Stack to simulate controlled recursion (lazy evaluation).
//   - On initialization, push all leftmost nodes of the tree onto the stack.
//   - For next(), pop from the stack and push all leftmost nodes of the right subtree.
//   - For hasNext(), simply check if the stack is not empty.

import java.util.Stack;

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

//Brute force - using arraylist to store all numbers using eager evaluation, doesnt support dynamic data handling
// class BSTIterator {
//     List<Integer> list;
//     Integer idx;

//     public BSTIterator(TreeNode root) {
//         this.list = new ArrayList<>();
//         this.idx = 0;
//         dfs(root);
//     }

//     private void dfs(TreeNode root) {
//         if(root == null)    return;

//         dfs(root.left);
//         list.add(root.val);
//         dfs(root.right);
//     }

//     public int next() {
//         return list.get(idx++);
//     }

//     public boolean hasNext() {
//         return idx < list.size();
//     }
// }

//Controlled recurssion - Best approach
//Approach is called - Lazy Evaluation - supports dynamic data handling as much as possible
public class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while(root != null) {   //push all left children
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = st.pop();
        dfs(temp.right);    //pass right subtree to dfs, if it is null then while will not execute
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public static TreeNode createSampleBST() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15, new TreeNode(9), new TreeNode(20));
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = createSampleBST();
        BSTIterator iterator = new BSTIterator(root);

        System.out.print("BST elements in ascending order: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
