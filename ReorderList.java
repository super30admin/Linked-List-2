// We maintain two pointers, first pointer at the head of the list and the second pointer pointing to the node after the head node. 
// The first node will point to the node after the second pointer and we update the first pointer. Similarly the second pointer will point to the node next to the first pointer.

// Time Complexity : O(n), where n is the number of nodes in the list
// Space Complexity : O(1)

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head, second = reverseLL(slow);
        ListNode temp;

        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }

    public ListNode reverseLL(ListNode node) {
        ListNode temp = null;
        while (node != null) {
            ListNode nextnode = node.next;
            node.next = temp;
            temp = node;
            node = nextnode;
        }
        return temp;
    }
}
