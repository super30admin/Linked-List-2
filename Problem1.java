import java.util.LinkedList;

/*
Time COmplexity -> O(N)
Space COmplexity -> O(N)
*/


class BSTIterator {
    LinkedList<Integer> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {

        inOrder(root);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        return list.poll();
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}