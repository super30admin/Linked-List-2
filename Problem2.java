// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//
//143. Reorder List
//https://leetcode.com/problems/reorder-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        // find mid
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tempHead = slow.next;
        fast = slow.next;
        slow.next = null;
        slow = head;

        ListNode temp = fast.next;
        int n = 0;
        fast.next = null;
        // reverse the second half of the list
        while (temp != null) {
            ListNode x = temp.next;
            temp.next = fast;
            fast = temp;
            temp = x;
        }

        if (temp != null)
            fast = temp;

        while (fast != null) {
            ListNode t = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = t;
            slow = t;
        }

    }
}