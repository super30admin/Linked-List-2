/**
 
 Time complexity O(n)
 
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        ListNode rev=reverse(slow.next);
        slow.next=null;
        slow=head;
        while(rev!=null){
            ListNode temp=slow.next;
            slow.next=rev;
            rev=rev.next;
            slow.next.next=temp;
            slow=temp;
        }
    }
    public ListNode reverse(ListNode slow){
        if(slow==null || slow.next==null) return slow;
        ListNode prev=null;
        ListNode curr=slow;
        
        while(curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
