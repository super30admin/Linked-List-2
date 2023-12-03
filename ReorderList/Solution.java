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

// Time Complexity : O(3n/2) -> O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Find mid using fast-slow pointer technique. Reverse the 2nd half of the list. Break the connection between mid and mid.next
 * Point slow to head and fast to head of reversed linked list. Now reorder the list with these 2 pointers.
 */
class Solution {
    public void reorderList(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) { //O(n/2)
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while(fast != null) {    //O(n/2)
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head) { //O(n/2)

        ListNode prev = null;

        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}