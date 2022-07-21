/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 1. Middle of the LinkedList
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        // 2. Reverse the second half of the LL
        fastPointer = reverseList(slowPointer.next);
        slowPointer.next = null;
        // 3. Merge two list together
        slowPointer = head;
        ListNode temp = null;
        while (fastPointer != null) {
            temp = slowPointer.next;
            slowPointer.next = fastPointer;
            fastPointer = fastPointer.next;
            slowPointer.next.next = temp;
            slowPointer = temp;
        }

    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode fast = head.next;

        while (fast != null) {
            current.next = previous;
            previous = current;
            current = fast;
            fast = fast.next;
        }
        current.next = previous;
        return current;
    }
}
