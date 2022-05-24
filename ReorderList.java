// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        //find the middle point
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse right side of mid
        fast = slow.next;
        ListNode prev = null;
        slow.next = null;
        while(fast!=null){
           ListNode next=fast.next;
           fast.next=prev;
           prev=fast;
           fast=next;
        }
        //merge
        fast = prev;
        while(fast!=null && head!=null){
            ListNode temp = head.next;
            head.next = fast;
            fast = fast.next;
            head.next.next = temp;
            head = temp;
        }
    }
}