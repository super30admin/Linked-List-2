// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    ListNode prev = null;

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        reverseLinkedList(head);

        ListNode head1 = head;
        ListNode head2 = prev.next;
        prev.next = null;

        int count = 1;
        while (head1 != null) {
            if (count % 2 != 0) {
                ListNode temp = head1.next;
                head1.next = head2;
                head1 = temp;
            } else {
                ListNode temp = head2.next;
                head2.next = head1;
                head2 = temp;
            }
            count++;
        }

    }

    private void reverseLinkedList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode prevCursor = new ListNode(0);
        prevCursor.next = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            prevCursor = prevCursor.next;
        }

        fast = slow.next;

        while (fast != null) {
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }

        slow.next = prev;

        prevCursor.next = slow;
        prev = prevCursor;
    }
}