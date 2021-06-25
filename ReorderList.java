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
// Time Complexity: O(n)
// Space Complexity: O(1)
//143. Reorder List - Medium
class Solution {
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null)
            return ;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode shead=slow.next;
        slow.next=null;
        
        shead=reverse(shead);
        ListNode temp1, temp2;
       // ListNode res=head;
        
        // we check shead-> node from secnd list !=null...because first list is always >= 2nd list length. So it is the second list node that might become null first
        while(shead!=null)
        {
            temp1=head.next;
            temp2=shead.next;
            head.next=shead;
            head.next.next=temp1;
            head=temp1;
            shead=temp2;
            
        }
    }
    
    public ListNode reverse(ListNode node)
    {
        ListNode prev=null;
        ListNode curr=node;
        ListNode next;
        
        while(curr!=null)
        {
            next=curr.next;
           curr.next=prev;
            prev=curr;
            curr=next;
          //  next=next.next;            
            
        }
        return prev;
    }
}