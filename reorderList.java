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
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = reverse(slow.next);
        slow.next=null;
        
        ListNode temp1;
        ListNode temp2;
        
        while(head1!=null && head2!=null){
             temp1 = head1.next;
            head1.next=head2;
             temp2 =head2.next;
            head2.next = temp1;
            //temp1.next=temp2;
            
            head1=temp1;
            head2=temp2;
                        
        }
        
        
    }
    
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr=temp;
        }
        
        return prev;
    }
}