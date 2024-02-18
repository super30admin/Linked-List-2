// Time Complexity : O(n)
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
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //find mid
        while(fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse linked list
        fast = reverse(slow.next);
        slow.next  = null;

        //merge list

        slow = head;
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = null;

        while(curr != null) {
            fast = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fast;
        }

        return prev;
    }
}