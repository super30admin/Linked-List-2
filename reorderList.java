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
       if(head==null || head.next==null) return;
       ListNode slow=head,fast=head;
       while(fast.next!=null && fast.next.next!=null){
           slow=slow.next;
           fast=fast.next.next;
       }
       fast=slow.next;
       ListNode prev=null;
       slow.next=null;
       while(fast!=null){
           ListNode next=fast.next;
           fast.next=prev;
           prev=fast;
           fast=next;
       }
       fast=prev;
       ListNode next;
       while(head!=null && fast!=null){
           next=head.next;
           head.next=fast;
           fast=fast.next;
           (head.next).next=next;
           head=next;
       }
       }
   }