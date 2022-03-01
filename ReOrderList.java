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
        
        if(head == null)
            return;
        
        //get to the middle of the Linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        } //by the end of this loop, slow will be at mid
        
        //reverse items from slow to the end of list
        ListNode prev = null;
        ListNode curr = slow;
        ListNode temp;
        
        while(curr!=null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        } // prev points to the head of this reversed list
        
        //merge the 2 halves 
        ListNode first = head;
        ListNode second = prev;
        
        while(second.next != null) {
            //one item from the first list
            //and point next to second
            temp = first.next;
            first.next = second;
            first = temp;
            
            //one item from the second list
            //and point its next to first
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}