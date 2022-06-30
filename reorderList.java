//T(N) = O(N)
//S(N) = O(1)
class Solution {
    public void disp(ListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
    public ListNode reversed(ListNode head)
    {
        if(head.next==null) return head;
        
        ListNode re= reversed(head.next);
        head.next.next=head;
        head.next=null;
        return re;
        
        
    }
    
    public void reorderList(ListNode head) {
       if(head.next==null||head.next.next==null)
           return;
        //disp(head);
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newNode=reversed(slow.next);
        slow.next=null;
        //disp(newNode);
        slow=head;
        ListNode p1,p2;
        while(slow.next!=null)
        {
            p1=slow.next;
            slow.next=newNode;
            p2=newNode.next;
            newNode.next=p1;
            slow=p1;
            newNode=p2;
        }
        slow.next=newNode;

    }
}