// in-order iterator for a Binary Search Tree (BST), returning the next smallest element on each call to next().
//use a stack to simulate in-order traversal by pushing all left children from the current node. On next(), it pops the top node, processes its right child by pushing its left descendants.
//Time complexity: O(n)
//Space complexity: O(h)
class BSTIterator {

    Stack <TreeNode> st;

    public BSTIterator(TreeNode root) {

        st = new Stack<>();

        TreeNode node = root;

        dfs(node);

    }

    

    /** @return the next smallest number */

    public int next() {

        TreeNode node = st.pop();

        dfs(node.right);

        return node.val;

    }

    

    /** @return whether we have a next smallest number */

    public boolean hasNext() {

        return !st.isEmpty();

    }

    private void dfs(TreeNode node){

        while(node != null){

            st.push(node);

            node = node.left;

        }

    }

}

