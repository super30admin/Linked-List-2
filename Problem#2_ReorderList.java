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
        //1. Find the mid of linked list
        ListNode slow = head;
        ListNode fast = head;
        //Reach the mid of Linked List
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.Reverse the second part of linked list
        //Resetting fast to start
        //Now we need to split the list and reverse 2nd part
        ListNode prev=null;
        ListNode curr = slow;
        ListNode next;
        while(curr!=null){
            
            next = curr.next;
            curr.next = prev;
            //Move prev ahead for upcoming nodes
            prev = curr;
            //and move slow or current to next
            curr = next;           
        }
        // Now we need to merge both
        /*MISTAKE made earlier - reset the fast and slow again before merging both Linked lists*/
        // Reuse fast pointer and reset fast to head now - for first half
        // Slow to previous (as it reaches null)
        fast = head;
        slow = prev;
        while(slow.next!=null){
            next = fast.next;
            fast.next = slow;
            fast = next;
            
            next = slow.next;
            slow.next = fast;
            slow = next;
        }
        
    }
}