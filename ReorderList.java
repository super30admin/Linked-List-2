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
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        //find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse from middle
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        //merge the two LL
        ListNode temp = null;
        while(fast != null) { //incase of odd length LL, fast will be smaller
            //incase of even length LL, fast length will be equal to slow length
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}