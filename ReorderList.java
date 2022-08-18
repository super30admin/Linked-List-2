// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * First we get a pointer to the middle of the linked list
 * Reverse the next half of the list
 * change the pointers to achieve the ordering
 *
 * We need extra caution while going to the middle of the list
 */

class Solution {
    public void reorderList(ListNode head) {
        // base condition
        if(head == null) {
            return;
        }
        
        // Get to the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the later part of the list
        ListNode reversed = reverseList(slow.next);
        
        // break the cycle
        slow.next = null;
        
        ListNode first = head;
        
        ListNode a = first;
        ListNode b = reversed;
        
        while (reversed != null) {
            ListNode next = first.next;
            first.next = reversed;
            reversed = reversed.next;
            first.next.next = next;
            first = next;
        }
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null) return head;
        
        ListNode next;
        ListNode prev = null;
        
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}