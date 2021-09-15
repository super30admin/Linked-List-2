public class Reorder {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        ListNode fast = head;
        ListNode slow = head;

        // finding middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversing

        ListNode current = slow.next;
        ListNode next = slow.next.next;
        ListNode prev = null;
        while (next != null) {

            current.next = prev;
            prev = current;
            current = next;

            next = next.next;
        }
        current.next = prev;
        slow.next = null;
        slow = head;

        ListNode temp = null;
        while (current != null) {
            temp = slow.next;
            slow.next = current;
            current = current.next;
            slow.next.next = temp;
            slow = temp;

        }

    }
}
