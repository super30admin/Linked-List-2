/*
This approach for BST iterator uses controlled recursion to handle the traversal of the BST, so that we can maintain as
dynamic of a BST as possible. Initially, it does a depth first search on the left half of the root of the tree. It maintains a
situation wherein, whenever the next() function is called, there will always be the correct next value that will be passed.
It does this by extracting the value at the current node, and then does a depth first search on the right half of that node,
to maintain the correct order for traversal(which is inorder). It will return the value of the current node only after it has
finished the dfs for the right half of that node, thus maintaining a controlled state of recursion.

Did this code run on Leetcode: Yes
*/
class BSTIterator {
    //Space complexity: O(h)
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    private void dfs(TreeNode root)
    {
        while(root != null)
        {
            st.push(root);
            root = root.left;
        }
    }
    //Time Complexity: O(1)
    public int next() {
        TreeNode curr = st.pop();
        int value = curr.val;
        dfs(curr.right);
        return value;
    }
    //Time Complexity: O(1)
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
