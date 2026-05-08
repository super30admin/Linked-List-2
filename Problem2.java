// https://leetcode.com/problems/reorder-list/
// Time Complexity : O(n) where n is the number of nodes in the linked list
// Space Complexity :  O(1) as we are not using any extra space, we are modifying the linked list in place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        while(curr!=null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        ListNode start = head;
        ListNode mid = prev;
        while(start.next!=null && mid.next!=null){
            ListNode t1 = start.next;
            start.next = mid;
            ListNode t2 = mid.next;
            mid.next = t1;
            start = t1;
            mid = t2;
        }
    }
}