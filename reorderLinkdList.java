//time complexity: O(n)
//space complexity:O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;//find the middle element
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;//disconnected the initial linked list 
        //from the reversed linked list
        slow=head;
        //merging of the reverse and initial linked list 
        while(fast!=null)
        {
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
    }
    //reversing the linked list
    private ListNode reverse(ListNode head)
    {
        
        ListNode prev=null;
        ListNode curr=head;
        ListNode fast=head.next;
        while (fast!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}
