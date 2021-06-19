// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * In this problem, the approach is divided into three parts:
 * 1. Find the middle of the List
 * 2. Reverse the second half of the List
 * 3. Now merge the first and reversed second half
 */

class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        // find the middle of the list
        
        ListNode prev = null;
        
        do {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            
        } while(fast != null && fast.next != null);
        
        
        // for odd length list, we need to move slow to one node more
        if(fast != null && fast.next == null) {
            prev = slow;
            slow = slow.next;
        }
        
        prev.next = null;
        
        // reverse the Second List
        // slow pointer will be pointing to the start of the next half of the list
        
        ListNode reversed = reverse(slow);
        
        // Now merge the two list
        // we can move fast to the start of the list
        
        fast = head;
        
        ListNode next = null;
        
        while(reversed != null) {
            next = fast.next;
            fast.next = reversed;
            reversed = reversed.next;
            fast.next.next = next;
            fast = next;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}