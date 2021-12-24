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

//T.C = O(n)
//S,.c = O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        {
            return;
        }
        
        ListNode slow = head ;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
       
        fast = reverse(slow.next);
        slow.next=null;
        
        
        slow = head;
        ListNode dummy = head;
        
        while(fast!=null)
        {
            dummy = dummy.next;
            slow.next= fast;
            slow=fast;
            fast= fast.next;
            slow.next=dummy;
            slow= dummy;
           
        }
        
    }
    
    private ListNode reverse(ListNode head)
    {
        
        ListNode prev=null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast!=null)
        {
           
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
            
            
            
        }
        curr.next = prev;
        
        return curr;
    }
}