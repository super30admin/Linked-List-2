//T.C O(N)
//S.C O(1)
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
    if(head==null || head.next==null)return;
      ListNode slow=head;
       ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
    //slow is at  half , point fast as this half point and reverse it
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
    
    public ListNode reverse(ListNode node){
        if(node==null || node.next==null) return node;
        ListNode prev=null;
        ListNode curr=node;
       
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
