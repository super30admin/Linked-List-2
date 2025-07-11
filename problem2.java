// Time Complexity : O(n) where n is the number of nodes in the linked list.
// Space Complexity : O(1) since we are not using any extra space apart from a few pointers.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I mainly did 3 things: move to the midpoint, reverse the second half of the list, and then merge the two halves together.
// I used first and second pointers to keep track of the two halves of the list - for every first, I add second to its next, and move it ahead by 2 steps (previous next) and also move second ahead by 1 step.

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

        // move to the mid point
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // need to reverse from mid to end
        ListNode prev = null;
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // prev is at the mid now such that after prev everything is in reverse
        ListNode first = head, second = prev;
        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}