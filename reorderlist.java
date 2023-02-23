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
        ListNode slow = head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=reverse(slow.next);
        slow.next=null;
        ListNode cur=head;
        while(head2!=null){
            ListNode temp= cur.next;
            cur.next=head2;
            head2=head2.next;
            cur.next.next= temp;
            cur=temp;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null)
        {
        ListNode temp= cur.next;
        cur.next=prev;
        prev=cur;
        cur=temp;}
        return prev;
    }
}