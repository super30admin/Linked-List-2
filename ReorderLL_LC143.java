/**

T:O(n/2) => o(n)
S: O(1)  

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
        if(head == null) return;
        
        //find the mid of the list 
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the list from slow.next onwards
        fast = reverse(slow.next);
        
        //detach 1st half of the list
        slow.next = null;
        
        slow = head;
        //merge the two LL
        while(fast != null){
            ListNode snext = slow.next;
            ListNode fnext = fast.next;
            
            slow.next = fast;            
            fast.next = snext;
            
            slow = snext;
            fast = fnext;
            
        }
    }
    
    private ListNode reverse(ListNode head){
        if(head == null) return null;
        
        ListNode curr = head;
        ListNode next = head;
        ListNode prev = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;    
    }
}