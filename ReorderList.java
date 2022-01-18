//Time Complexity: O(n)
//Space Complexity: O(1)
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
        if(head==null)
            return;
        ListNode mid=null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        head2=reverse(head2);
        ListNode head1=head;
        //merge
        while(head2!=null){
            ListNode temp=head1.next;
            head1.next=head2;
            head2=head2.next;
            head1.next.next=temp;
            head1=temp;
            
        }
        
    }
    
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
      
        ListNode prev=null;
        ListNode curr=head;
        ListNode fast=head.next;
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}
