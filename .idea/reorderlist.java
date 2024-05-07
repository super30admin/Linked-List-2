// Time Complexity : O(N)
// Space Complexity : 0(1)
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

        while(fast != null && fast.next != null){
            slow = slow.next; // Slow pointer moves 1 step
            fast = fast.next.next; // Fast pointer moves 2 steps
        }

        // Reverse the second half of the list
        fast = reversedList(slow.next);
        slow.next = null; // Break the original list into two halves
        slow = head; // Reset slow pointer to the beginning of the list

        // Reorder the list by alternating nodes from the first and reversed second halves
        while(slow != null && fast != null){
            ListNode temp = slow.next; // Store next node in the first half
            slow.next = fast; // Connect current node in the first half to node in reversed second half
            fast = fast.next; // Move to the next node in the reversed second half
            slow.next.next = temp; // Connect node in reversed second half to next node in the first half
            slow = temp; // Move to the next node in the first half
        }
    }


    private ListNode reversedList(ListNode head){ // Function to reverse a linked list
        ListNode prev = null;
        ListNode curr = head;

        // Reverse the list
        while(curr != null){
            ListNode temp = curr.next; // Store next node
            curr.next = prev; // Point current node to previous node
            prev = curr; // Move previous pointer to current node
            curr = temp; // Move current pointer to next node
        }
        return prev; // Return the new head of the reversed list
    }
}
