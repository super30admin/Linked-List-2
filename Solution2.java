// Time Complexity :O(n) for finding midpoint, reverse half a list, merging them
// Space Complexity :O(1) no extra space needed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;
    // Step 1 Find mid point
        ListNode slow=head;
        ListNode fast=head.next;
    // Step 2 Reverse second half of the list
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;
        ListNode dummy=head.next;
        slow=head;
    // Step 3 Merge the list
        while(fast!=null){
            slow.next=fast;
            fast=fast.next;
            slow.next.next=dummy;
            slow=dummy;
            if(dummy!=null){
                dummy=dummy.next;
            }
        }
    }
    private ListNode reverse(ListNode head){
        ListNode prev= null;
        ListNode fast=head.next;
        ListNode curr= head;
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