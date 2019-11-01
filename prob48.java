/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if( head==null || head.next == null ) return;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            
        }
        ListNode head2 = slow.next;
        slow.next =null;
        
        ListNode prev = null;
        ListNode cur = head2;
        ListNode next;
        
        while(cur != null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head2=prev;
        while(head2 != null){
            ListNode temp= head.next;
            head.next=head2;
            ListNode temp2=head2.next;
            head2.next=temp;
            head=temp;
            head2=temp2;
        }
        
    }
}