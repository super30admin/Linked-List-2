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
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * 1) divide the linkedlist into 2 parts using lsow and fast pointer
 * 2) Reverse the 2nd half
 * 3) merge the 2 linkedlist to reorder
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // finding middle

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the 2nd half
        ListNode current = slow.next;
        ListNode first = current.next;
        ListNode prev = null;
        slow.next = null;

        while (first != null) {
            current.next = prev;
            prev = current;
            current = first;
            first = first.next;
        }

        current.next = prev;

        // merge the 2 lists

        slow = head;
        fast = current;

        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }
}