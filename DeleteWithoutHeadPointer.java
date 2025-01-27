/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class DeleteWithoutHeadPointer {

    void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        ListNode successor = node.next;
        node.val = successor.val;
        node.next = successor.next;
        successor = null;
        return;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
