// Time Complexity : O(N);
// Space Complexity :O(1);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        // Base case: if the current node or next node is null, return head
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively reverse the rest of the linked list
        ListNode lastHead = reverse(head.next);
        
        // Reverse the link between current node (head) and next node
        head.next.next = head;
        head.next = null; // Set current node's next to null to break the original link
        
        return lastHead; // Return the new head of the reversed linked list
    }
    
    // Method to reorder the linked list
    public void reorderList(ListNode head) {
        // Find middle of linked list to split it into two halves
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode p2 = reverse(slow.next);
        slow.next = null; // Split the first half by setting slow.next to null
        
        ListNode p1 = head; // Pointer to iterate through the first half
        
        // Merge two lists: p1 (first half) and p2 (reversed second half)
        while (p2 != null) {
            ListNode temp = p1.next; // Temporarily store p1's next node
            p1.next = p2; // Link p1 to p2
            p2 = p2.next; // Move p2 to its next node
            p1.next.next = temp; // Link p2's next to p1's original next
            p1 = temp; // Move p1 to its original next node
        }
    }
}
