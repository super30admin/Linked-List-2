/**
    Time Complexity : O(N)
    Explanation:
    1) Find middle using slow-fast pointer → O(N)
    2) Reverse second half → O(N)
    3) Merge two halves → O(N)

    Space Complexity : O(1)
    Explanation:
    All operations are done in-place without extra space.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially had difficulty merging the two halves correctly
    after reversing the second half.
    Also needed to carefully break the list into two parts
    to avoid cycles while merging.
    Fixed it by:
        1) Finding middle
        2) Reversing second half
        3) Merging nodes alternately
    */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {


    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        int c = 0;

        // Step 1: Find middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            c++;
        }

        if (c >= 1) {

            // Step 2: Reverse second half
            ListNode curr = slow.next;
            ListNode prev = null;

            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Break first half
            slow.next = null;

            // Step 3: Merge two halves
            slow = head;
            fast = prev;

            while (fast != null) {
                ListNode temp = slow.next;

                slow.next = fast;
                fast = fast.next;

                slow.next.next = temp;
                slow = temp;
            }
        }
    }
}