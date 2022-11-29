// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        
        //find middle of linked list
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //reverse linked list
        fast=slow.next;
        fast=reverse(fast);
        
        
        slow.next=null; 
        slow=head;
        
        while(fast!=null){
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
        
        
        
    }
    
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode prev=null;
        ListNode fast=head.next;
        
        while(fast!=null){
            head.next=prev;
            prev=head;
            head=fast;
            fast=fast.next;
            
        }
        
        head.next=prev;
        return head;
            
    }
}