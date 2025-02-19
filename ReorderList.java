// Time Complexity functions: O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
/*
 * Using slow and fast pointer find mid of the list. From the next node of mid, reverse the remaining list. Make mid.next=null so that we get 2 different 
 * lists. Now merge them both in the required order starting from head of both.
 */
class ReorderList {
    public void reorderList(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        //find mid
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse
        fast=reverse(slow.next);
        slow.next=null;
        slow=head;
        //System.out.println(slow.val+" "+fast.val);
        //merge
        while(fast!=null){
            ListNode tmp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=tmp;
            slow=tmp;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode tmp=head.next;
            head.next=prev;
            prev=head;
            head=tmp;
        }
        return prev;
    }
}
