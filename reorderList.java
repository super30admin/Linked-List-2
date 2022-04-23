//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public void reorderList(ListNode head) {
        //base case
        if(head==null||head.next==null)
            return;
        //to find the middle node, initialize 2pointers slow and fast
        //slow by 1node and fast by 2nodes
        ListNode s=head, f=head;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        //after we get slow pointer at mid node, reversing the 2nd half
        f=reverse(s.next);
        //breaking the list into 2lists
        s.next=null;
        //combine the 2lists
        s=head;
        //temporary variable
        ListNode temp=null;
        while(f!=null){
            //update temporary
            temp=s.next;
            s.next=f;
            f=f.next;
            s.next.next=temp;
            s=temp;
        }
    }
    //reverse method
    private ListNode reverse(ListNode head){
        //base case
        if(head==null||head.next==null)
            return head;
        //initilaize 3pointers for previous, current and fast positions
        ListNode p=null, c=head, f=head.next;
        while(f!=null){
            c.next=p;
            p=c;
            c=f;
            f=f.next;
        }
        c.next=p;
        return c;
    }
}