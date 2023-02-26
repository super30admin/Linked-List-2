class BSTIterator {

    List<Integer> nodes;
    int index;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        index = -1;
        inorder(root);
    }

    public int next() {
        index++;
        return nodes.get(index);
    }

    public boolean hasNext() {
        if(index == nodes.size() - 1) {
            return false;
        }
        return true;
    }

    private void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            nodes.add(root.val);
            inorder(root.right);
        }
    }
}