Time Complexity-O(n)
Space Complexity-O(1)

class Solution {
    
    private ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
            ListNode slow=head;
            ListNode fast=head.next;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode middle=slow;
        fast=reverse(slow.next);
        
        slow.next=null;
        slow=head;
        while(slow!=null && fast!=null)
        {
            ListNode temp=fast.next;
            fast.next=slow.next;
            slow.next=fast;
            slow=fast.next;
            fast=temp;
            
            
        }
        
     
        return;
        
    }
}
