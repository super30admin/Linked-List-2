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
//Time complexity: O(n)
//Space complexity: O(1)
class Solution {
    
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode slow=head;
        ListNode fast=head;
        ListNode middle= middleNode(head);
        
        fast= middle.next;
        slow=head;
        middle.next=null;
        fast=reverse(fast);

        while(slow!=null && fast!=null)
        {
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
        
    }
    public ListNode middleNode(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=curr.next;
        while(temp!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=temp;
            temp=temp.next;
        }
        curr.next=prev;
        return curr;
        
    }
}