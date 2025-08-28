// Time Complexity : O(n), since we traverse the list a few times (finding middle, reversing, merging).
// Space Complexity : O(1), no extra space used, everything is done in-place.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially tricky to handle edge cases and pointer updates.
//
// Approach :
// 1. Find the middle of the linked list using slow and fast pointers.
// 2. Reverse the second half of the list.
// 3. Merge the two halves alternately (first from left half, then from reversed right half).

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find middle using slow & fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        fast = reverse(slow.next);
        slow.next = null; // cut the list into two halves
        slow = head;

        // Step 3: Merge two halves alternately
        while (slow != null && fast != null) {
            ListNode leftnext = slow.next;
            ListNode rightnext = fast.next;

            slow.next = fast;
            fast.next = leftnext;

            slow = leftnext;
            fast = rightnext;
        }
    }

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

// Node Definition
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
