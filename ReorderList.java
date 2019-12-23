Time Complexity-O(n)
Space Complexity-O(1)

class Solution { 
    
    public void merge(ListNode p1,ListNode p2,ListNode middle)
    {
            while(p1!=middle){
                middle.next=p2.next;
                p2.next=p1.next;
                p1.next=p2;
                p1=p2.next;
                p2=middle.next;
            }
    }
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
        slow.next=reverse(slow.next);
        merge(head,middle.next,middle);
        return;
        
    }
}
