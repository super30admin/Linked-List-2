// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Find the middle of the linked list and split it into two halves.
// Reverse the second half of the list in-place.
// Merge both halves alternately to reorder the list.

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find middle of the list using slow & fast pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split the list into two halves
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;

        // 3. Reverse the second half
        ListNode prev = null;
        while (head2 != null) {
            ListNode temp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = temp;
        }
        head2 = prev;

        // 4. Merge the two halves alternately
        while (head2 != null) {
            ListNode temp = head1.next;
            head1.next = head2;

            ListNode temp1 = head2.next;
            head2.next = temp;

            head1 = temp;
            head2 = temp1;
        }
    }
}