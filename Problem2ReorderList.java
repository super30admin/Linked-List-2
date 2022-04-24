//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


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
        if(head==null || head.next ==null) return;
        
        //find the middle
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //reversing the second half
        fast=reverse(slow.next);
        //splitting the list in 2 portions
        slow.next=null;
        //merge the two parts
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
    //reverse method
    private ListNode reverse(ListNode head){
        //base case
        if(head==null||head.next==null)
            return head;
        //initilaize 3pointers for previous, current and fast positions
        ListNode p=null, c=head, f=head.next;
        while(f!=null){
            c.next=p;
            p=c;
            c=f;
            f=f.next;
        }
        c.next=p;
        return c;
    }
}