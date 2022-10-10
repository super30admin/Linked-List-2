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

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // 1. Find middle
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // 2. Reverse Second Half
        fast = reverse(slow.next);
        slow.next = null;
        
        //3. Merging two lists
        slow = head;
        ListNode temp = slow.next;
        while(fast != null){
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
            if(temp != null)
                temp = temp.next;
        }
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        
        return curr;
    }
}
