/*
Time complexity - O(N) - where N is the number of elements
Space complexity - O(1) - no extra space is used

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr=reverse(slow.next);
        slow.next=null;
        ListNode s=curr;
        ListNode f=head;
        //finding the final
        while(s!=null && f!=null)
        {
            ListNode temp=f.next;
            f.next=s;
            s=s.next;
            f.next.next=temp;
            f=f.next.next;
        }
    }
    private ListNode reverse(ListNode curr)
    {   
        if(curr==null || curr.next==null)
            return curr;
        ListNode prev=null;
        while(curr!=null && curr.next!=null)
        {
            ListNode nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        curr.next=prev;
        return curr;
    }
}
