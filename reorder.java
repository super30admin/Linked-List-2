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
    // Did this code successfully run on Leetcode : Yes
    // Time Complexity : O(n); n = head.length
    // Space Complexity: O(1)
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        // Split the list in half
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // Reverse the 2nd half of the list
        prev = null;

        while(slow != null) {
            ListNode next = slow.next;
            slow.next = prev;

            prev = slow;
            slow = next;
        }

        // Attach the two lists together
        // 'prev' is pointing at head of list 2
        ListNode curr = head;

        while(curr != null) {
            ListNode next1 = curr.next;
            ListNode next2 = prev.next;

            curr.next = prev;
            if(next1 != null) {
                prev.next = next1;
            }

            curr = next1;
            prev = next2;
        }
    }
}