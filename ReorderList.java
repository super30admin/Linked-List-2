/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rev = slow.next;
        slow.next = null;

        if (rev == null) {
            return;
        }
        ListNode revHead = reverse(rev);

        ListNode curr1 = head;
        ListNode curr2 = revHead;

        ListNode temp1 = curr1.next;
        ListNode temp2 = curr2.next;

        while (curr2 != null) {


            curr1.next = curr2;
            curr2.next = temp1;

            curr1 = temp1;
            curr2 = temp2;

            if (curr1 != null)
                temp1 = curr1.next;
            if (curr2 != null)
                temp2 = curr2.next;

        }
        return;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return first;
    }
}
