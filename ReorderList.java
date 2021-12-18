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
// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return ;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=reverse(slow.next);
        slow.next=null;
        
        slow=head;
        ListNode dummy=slow.next;
        while(fast!=null){
            slow.next=fast;
            fast=fast.next;
            slow.next.next=dummy;
            slow=dummy;
            if(dummy==null) break;
            dummy=dummy.next;
            
        }
       
    }
    ListNode reverse(ListNode head){
        
        if(head==null) return null;
        ListNode curr=head;
        ListNode prev=null;
        ListNode forward=head.next;
        while(forward!=null){
            curr.next=prev;
            prev=curr;
            curr=forward;
            forward=forward.next;
            
            
        }
        curr.next=prev;
        return curr;
    }
}
