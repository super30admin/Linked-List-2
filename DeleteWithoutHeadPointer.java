class DeleteWithoutHeadPointer {

    //O(1) time and space
    public void deleteNode(TreeNode node) {

        TreeNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        temp = null;

    }

}