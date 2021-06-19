
//Time complexity - O(1)
// Space complexity - O(N)


class BSTIterator {

    Stack<TreeNode> stk;

    public BSTIterator(TreeNode root) {
        this.stk = new Stack<TreeNode>();


        this.leftinOrder(root);


    }

    private void leftinOrder(TreeNode root){

        while(root != null) {

            this.stk.push(root);
            root = root.left;

        }

    }

    public int next() {

        TreeNode topMost = this.stk.pop();

        if(topMost.right != null) {

            this.leftinOrder(topMost.right);


        }

        return topMost.val;


    }

    public boolean hasNext() {

        return this.stk.size() > 0;

    }
}