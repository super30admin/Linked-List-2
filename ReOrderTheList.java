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
// time complexity 0(n)
// space complexity 0(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next== null)
        {
            return;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;

        slow = head;
        ListNode temp = null;

        while(fast!=null)
        {
            temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }

    }

    private ListNode reverse(ListNode head)
    {
        if(head== null || head.next== null)
        {
            return head;
        }
        ListNode prev = null;
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