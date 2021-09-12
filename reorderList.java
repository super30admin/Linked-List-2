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

// Time Complexity: O(2n+n/2) We are traversing list once to get the mid point then reversing the list from mid point to end and updating list again from start to end.
// Space Complexity: O(1) done inplace
// Did you completed it on leetcode: Yes
// Any problems faced: Difficulty in implementation

// Write your approach here:
// Idea here is to make 2 distinct pointers from where we can grab first and last, 2nd and 2nd last and so on nodes and place them in correct order.
// To do so we first found mid point and reversed the list former to mid
// now we can pick starting from head on 1 pointer and starting from next to mid on 2nd pointer and place them.
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode cur = slow.next;
        if(cur!=null) {
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }
        while(cur!=null) {
            ListNode temp = cur.next;
            cur.next = mid.next;
            mid.next = cur;
            cur = temp;
        }
        ListNode left = head;
        ListNode right = mid.next;
        while(right!=null) {
            mid.next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = mid.next;
        }
    }
}