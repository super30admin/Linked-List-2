// Time complexity: O(1)
// Space complexity: O(1)

class DeleteNode {
    public void deleteNode(ListNode node) {
        // copy the next node val
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
