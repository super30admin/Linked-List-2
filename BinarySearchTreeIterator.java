/**
 * Time Complexity : O(1) (next operation)
                     O(1)(hasNext operation)
                     O(h) Setting up the iterator (first left traversal)

Space Complexity : O(h) size of the stack

//Here at the time of setting up the iterator , we will be traversing to left leaf noode
//At the time of removal, we will be calling the same operation (left leaf node traversal) on the removed node
 */


import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> st;
    public BinarySearchTreeIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        dfs(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode element = st.pop();
        dfs(element.right);
        return element.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void dfs(TreeNode root)
    {
        if(root == null) return;
        st.add(root);
        dfs(root.left);
    }
}

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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }