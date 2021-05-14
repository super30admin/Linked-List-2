// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


public class orderList {

    public void reorderList(ListNode head) {
        
        ListNode slow=head;
        ListNode fast=head;
        
        
        if(head==null || head.next==null)
            return;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        fast=reverse(slow.next);
        slow.next=null;        
        slow=head;
        
        ListNode current;
        while(fast!=null){
            current=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=current;
            slow=current;
        }
        
        
        
    }
    
     private ListNode reverse(ListNode head){
        
        ListNode prev=null;
        
        while(head !=null){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;   
        }
        
        return prev;
    }
    
}
