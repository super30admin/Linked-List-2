/*
Time Complexity: O(n) where n is the number of nodes in the linked list.
Space Complexity: O(1) since we are not using any extra space except for a few variables. 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: The idea is to reverse the second half of the linked list 
and then merge it with the first half.

*/

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode curr = head;

        while (curr != null && curr.next != null && curr.next.next != null) {
            ListNode reversed = reverseList(curr.next);

            ListNode nextCurr = curr.next;
            ListNode tail = reversed;

            ListNode prev = null;
            while (tail != null && tail.next != null) {
                prev = tail;
                tail = tail.next;
            }

            curr.next = tail;
            tail.next = nextCurr;

            if (prev != null) {
                prev.next = null;
            }

            curr = nextCurr;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
