//https://leetcode.com/problems/reorder-list/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//2 half parts of linked list
//reverse the second half
//alternatively connect first and reversed second in one LL.

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
        //split in halves
        ListNode slow= head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;
        slow=head;
        //merge
        while(fast!=null){
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
        return;
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode current= head;
        while(current!=null){
            ListNode temp = current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
    }
}