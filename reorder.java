// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

     

        fast= reverse(slow.next);
        slow.next=null;
        slow=head;

       
        while(fast!=null){
            ListNode curr = slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=curr;
            slow=curr;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode after = null;
        ListNode prev = null;

        while(curr!=null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
}