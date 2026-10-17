class Solution {
    public void deleteNode(Node del) {
        if (del == null || del.next == null) {
            // Cannot delete the node if it's the last node
            return;
        }

        del.data = del.next.data;
        del.next = del.next.next;
    }
}