/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// time: O(n)
// space: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;
        slow=head;
        ListNode curr;
        // join 2 list
        while(fast!=null)
        {
            curr=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=curr;
            slow=curr;
            //curr=curr.next;
        }
    }
    // to reverse
    private ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode fast=head.next;
        while(fast!=null)
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