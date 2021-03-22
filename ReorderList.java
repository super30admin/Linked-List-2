// Time Complexity : O(n) since 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
-> find the mid of the linkedlist with slow and fast pointers
-> Split the two lists
-> Reverse the second list
->Now combine the two lists iterating i'th node in each list
*/
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
        if(head == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        //slow and fast pointers
        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast = fast.next.next;
        }
        //reverse second half
        fast = reverse(slow.next);
        slow.next=null;
        
        //combining list
        slow=head;
        
        while(fast!=null && slow!=null){
            ListNode nextslow=slow.next;
            ListNode nextfast=fast.next;
            
            slow.next=fast;
            fast.next=nextslow;
            
            slow=nextslow;
            fast=nextfast;           
        }     
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next = head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}