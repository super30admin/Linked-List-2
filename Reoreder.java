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
        ListNode sptr=head;
        ListNode fptr=head;
        if(head==null || head.next==null || head.next.next==null) return;
       
        while(fptr.next!=null && fptr.next.next!=null){
            sptr=sptr.next;
            fptr=fptr.next.next;
        }
        fptr=reverse(sptr.next);
        sptr.next=null;
        sptr=head;
        while(fptr!=null){
            ListNode temp;
            temp = sptr.next;
            sptr.next=fptr;
            fptr=fptr.next;
            sptr.next.next=temp;
            sptr=temp;
            
        }
        
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=curr.next;
        }
        curr.next=prev;
        return curr;
    }
}