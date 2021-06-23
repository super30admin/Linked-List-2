// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


public class ReOrderList {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)return;
        //find the middle
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        //separate the LinkedLists
       ListNode mid=slow;
       ListNode LL1=head; 
       ListNode LL2=mid.next;
       mid.next=null;
       //reverse LL2
        LL2=reverse(LL2);
        
        //Reorder
        ListNode prev=null;
        while(LL2!=null)
        {
            ListNode temp=LL1.next;
            LL1.next=LL2;
            LL2=LL2.next;
            LL1.next.next=temp;
            LL1=temp;
        }
       
        
    }
    
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode forward=head.next;
        while(forward!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=forward;
            forward=forward.next;
        }
        curr.next=prev;
       
        return curr;
    } 
}
