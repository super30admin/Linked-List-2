// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes 
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        fast=helper(slow.next);
        slow.next=null;
        slow=head;
        ListNode curr=null;
       
        while(fast!=null)
        {
            curr=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=curr;
            slow=curr;
   
        }

  
        
    }
    
    private ListNode helper (ListNode head)
    {
        ListNode temp=null;
        ListNode rev=null;;
        while(head!=null)
        {
           rev=head; 
           head=head.next; 
           rev.next=temp;
           temp=rev;
            
        }
        return rev;
    }
}