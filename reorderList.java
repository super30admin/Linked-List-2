// Time Complexity : O(n) where n is the length of the LL
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class reorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse from middle+1 to end
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        // merge head to middle and reversed of middle+1 to end
        while (slow != null && fast != null) {
            ListNode next = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = next;
            slow = next;
        }
        return;
    }
    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}