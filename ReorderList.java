/**
 * Time Complexity: O(N), Space Complexity: O(1)
 * LeetCode: Y (https://leetcode.com/problems/reorder-list/)
 * Look out for cycle in the Linked List, be careful with pointers when traversing the Linked list
 * Approach: 
 *  Get the Middle Node of the Linked list
 *  Reverse the second half
 *  Splice the first and second half together
 */
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
        // If the Linked list is empty or has up to 2 nodes then return as no reordering is required
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        //Get the middle node of the Linked list
        ListNode middleNode = getMiddleNode(head);
        
        // Reverse the second half
        ListNode headOfreversedSecondHalf = reverseLinkedList(middleNode.next);

        // IMPORTANT: BREAK THE LINKED LIST AFTER FIRST HALF TO AVOID CYCLE IN LINKED LIST
        middleNode.next = null;
        
        // Reorder the two halves with current1 and current2
        ListNode current1 = head, current2 = headOfreversedSecondHalf;
        
        // Continue reordering until there are nodes in the second half
        while(current2 != null) {
            // Get the next node of current1 in first half
            ListNode temp = current1.next;
            
            // Splice the first half with second half
            current1.next = current2;
            
            // Move current2 forward in the second half
            current2 = current2.next;
            
            // Finish Splicing
            current1.next.next = temp;
            
            // Move current1 forward in the first half
            current1 = temp;
        }
        
    }
    
    // Helper function to get Middle Node of the Linked List
    // 1 -> 2 -> 3 -> 4 -> 5: returns 3
    // 1 -> 2 -> 3 -> 4 -> 5 -> 6: returns 3
    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // Helper function to reverse a Linked List
    private ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null, current = head;
        
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
    }
}
