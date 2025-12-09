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
// Approach: Two pointers: slow and fast
// Time: O(N)
// Space: O(1)
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // find mid
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half of the linked list
        fast = reverse(slow.next);
        slow.next = null;

        // merge first half list and second half reversed list
        slow = head;
        while (fast != null) {
            ListNode slowNext = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = slowNext;
            slow = slowNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}