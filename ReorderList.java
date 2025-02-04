// Time Complexity : O (n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes

// First, go to the halfway point
// Second, reverse the second half of the list
// Third, merge the two halves
public class ReorderList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
    }

    public void reorderList(ListNode head) {
        //edge cases
        if (head == null || head.next == null) return;

        // first go to halfway point (slow marks halfway)
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the list
        ListNode ptr = slow;
        ListNode prev = null;
        ListNode temp;
        while (ptr != null) {
            temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
        }

        // merge the two halves of the list
        // (the first half and the reversed second half)
        ptr = head;
        ListNode ptr2 = prev;
        ListNode temp2;
        while (ptr2.next != null) {
            temp = ptr.next;
            temp2 = ptr2.next;
            ptr.next = ptr2;
            ptr2.next = temp;
            ptr = temp;
            ptr2 = temp2;
        }
    }
}
