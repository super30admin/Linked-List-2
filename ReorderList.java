// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.
// Your code here along with comments explaining your approach
/*
Break list int two, reverse second half and merge them alternate fashion
* */
class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        ListNode prev=null;
        while(fast.next!=null && fast.next.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        fast=reverse(slow.next);
        slow.next=null;

        slow=head;
        ListNode temp=null;
        while(fast!=null){
            temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }

    }

    private ListNode reverse(ListNode head){
        if(head==null)
            return null;

        ListNode curr=head.next;
        ListNode prev=head;

        while(curr!=null){
            prev.next=curr.next;
            curr.next=head;
            head=curr;
            curr=prev.next;
        }

        return head;
    }
}