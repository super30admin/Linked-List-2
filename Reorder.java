// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
class Reorder {
    ListNode secondHead = null;
    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
        }

        ListNode prev = null, curr = slow, tmp;
        while (curr != null) {
          tmp = curr.next;

          curr.next = prev;
          prev = curr;
          curr = tmp;
        }

        ListNode first = head, second = prev;
        while (second.next != null) {
          tmp = first.next;
          first.next = second;
          first = tmp;

          tmp = second.next;
          second.next = first;
          second = tmp;
        }
    }
}
