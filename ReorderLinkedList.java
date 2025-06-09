// Time Complexity : O(n) here, finding middle is O(n/2), reverse list is O(n/2), merge list O(n)
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
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //find middle
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        //merge
        while(fast!= null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}