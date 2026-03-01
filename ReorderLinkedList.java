public class ReorderLinkedList {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head;
        ListNode temp = head;
        ListNode prev = head;
        // base case
        if (fast == null || fast.next == null) return;
        // move n/ 2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse from the next n/2 + 1
        curr = slow.next;
        temp = null;
        if (slow.next != null) {
            slow.next = null;
        }


        while (curr != null) {
            fast = curr.next;
            curr.next = temp;
            temp = curr;
            curr = fast;
        }
        curr = temp;

        // link the two linked list
        while(curr != null) {
            fast = head.next;
            head.next = curr;
            temp = curr.next;
            curr.next = fast;
            curr = temp;
            head = fast;
        }
    }
}