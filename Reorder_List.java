// Time Complexity :O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No



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
    
    //getting slow at midpoint 
    while(fast.next != null && fast.next.next != null ){
       slow = slow.next;
       fast =fast.next.next;  
    }    
        
    //reversing second half 
    fast = reverse(slow.next);
    slow.next = null;
    
    //1-2-3
    //5-4-1
    //merging list
    slow = head;
    while(fast!= null){
        ListNode temp = slow.next;
        slow.next = fast;
        fast = fast.next;
        slow.next.next = temp;
        slow = temp;
    }         
    }
    
    
    private ListNode reverse(ListNode head){  
    ListNode temp; 
    ListNode prev = null;
    ListNode current = head;
        
    while(current != null){
        temp = current.next ;
        current.next = prev;
        prev = current;
        current = temp;
     } 
    return prev;
    }
}
