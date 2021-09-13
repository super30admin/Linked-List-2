/*
Time: O(N)
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class ReorderList {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        // step 1. Cut the list to two halves
        ListNode firstHalfEnd = endOfFirstHalf(head);
        // step 2. Reverse the 2nd half
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        firstHalfEnd.next = null;

        // step 3. Merge the two halves
        mergeTwoLists(head, secondHalfStart);

    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { // no new result list needed in recursive

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        l1.next = mergeTwoLists(l2, l1.next); // note l2 first and then l1.next
        return l1;

    }

}