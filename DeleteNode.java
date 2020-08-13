public class DeleteNode {
    public void deleteNode(ListNode node) {
        if (node == null) return;

        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }
}
