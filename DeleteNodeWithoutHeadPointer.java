// Here the node that needs to be deleted is directly given. So all we need to do is assign the next nodes value to the given node and point the current nodes
// next value to the next to next node of the given node.

// Time Complexity : O(1)
// Space Complexity : O(1)

public class DeleteNodeWithoutHeadPointer {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
