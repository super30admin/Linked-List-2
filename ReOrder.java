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


//Time Complexity: O(n).
//Space Complexity: O(1).
//No extra space is required. 
//This problem is basically pointer modification by finding the middle of the linkedlist. 


class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        //find the middle of the linkedlist;
        
        ListNode slow = head;
        ListNode fast = head;
        
        
        //check the operation of && operator for checking the condition. 
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //Reverse second half
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        //merge the two;
        ListNode temp = null;
        
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
       
        
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
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

