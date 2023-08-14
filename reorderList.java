class Solution {
    public void reorderList(ListNode head) {
        
        if(head==null) return;
       
//         traverse till you get middle
        ListNode slow=head;
        ListNode fast=head;
    
        while(fast!= null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        
//         Reverse from middle
        ListNode curr,temp,prev=null;
        curr=slow;
        
        while(curr!=null){
            temp=curr.next;
            curr.next= prev;
            prev= curr;
            curr= temp;
        }
        
//         Merge two sorted lists
        ListNode first=head, second=prev,tmp;
        
        while(second.next!=null){
            tmp=first.next;
            first.next=second;
            first=tmp;
            
            tmp= second.next;
            second.next=first;
            second=tmp; 
        }
    }
}
