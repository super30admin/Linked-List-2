// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/reorder-list/)

// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln

// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

// You may not modify the values in the list's nodes. Only nodes themselves may be changed.
// Example 1:
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]

// Example 2:
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
 
// Constraints:
// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000

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
        // Edge case: if list is empty or has only one node, no reordering needed
        if (head == null || head.next == null){
            return;
        }

        // Step 1: Finding the middle of the list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reversing the second half of the list
        // fast will now point to the head of the reversed second half
        fast = reverseList(slow.next);

        // Breaking the list into two halves
        slow.next = null;

        // Step 3: Merging the two halves alternatively
        slow = head;
        while (fast != null){

            // Storing the next node of the first half
            ListNode temp = slow.next;

            // Inserting a node from the second half
            slow.next = fast;            
            fast = fast.next;

            // Connecting back to the first half
            slow.next.next = temp;

            // Moving to the next node in the first half
            slow = temp;
        }
    }   

    // Helper function to reverse a Linked List
    private ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = curr.next;

        // iteratively reversing the list
        while (nxt != null){
            curr.next = prev;
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
        }
        curr.next = prev; // final pointer reversal

        return curr;
    }
}