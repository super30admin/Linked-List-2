// Time Complexity : O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We first find the mid of the LinkedList and reverse the second part because the order of insertion will be easier. Now we use one element from
// first part and one from second part and merge them.


class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //Find mid point
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // break first and second halves

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //  Merge two halves
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
