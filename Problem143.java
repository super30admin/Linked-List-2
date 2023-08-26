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

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next!=null) // handle both even and odd no.of elements
        {
            slow= slow.next;
            fast = fast.next.next;
        }
        
        //Now slow is pointing to middle element ans we need to find reverse of other half of list
         fast = slow.next;
         slow.next = null;  // break the connection b/w two lists
         slow = head; // move slow to start of the list to use it in merging

         //now reverse the list
         ListNode prev =null;
         ListNode curr = fast;
         ListNode next = curr;
         while(curr!=null){
             next = curr.next;
             curr.next= prev;
             prev= curr;
             curr = next;
         }
        
        fast = prev; // now prev has start of the reversed list
        
        //merge two lists
         while(fast!=null){
            ListNode temp = slow.next;
            slow.next= fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
}