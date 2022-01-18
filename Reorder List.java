// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        
        //check for empty linked list or if it has a single element
        if(head == null || head.next == null) return;
        
        // initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        
        // find the middle
        // keep moving slow by 1x speed and fast by 2x speed
        // slow pointer will be at middle
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse
        // call the reverse method on node next to middle
        fast = reverse(slow.next);
        
        // remove the existing link between slow and mid + 1 element
        slow.next = null;
        
        // move slow to head
        slow = head;
        
        // merge the two lists
        ListNode temp = null;
        
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    // function to reverse a linked list
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        return curr;
    }
    
}