// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to learn the concepts.

/*
 * Problem#143
 * 
 * Three subproblems:
 * 1. Find the middle - TimeComplexity (O(n/2))
 * 2. Reverse the linkedList - TimeComplexity (O(n/2))
 * 3. Reorder the linkedList- TimeComplexity (O(n/2))
 */

public class ReOrderList {

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Slow is the middle node

        // Reverse the second half
        fast = reverseTheLinkListNode(slow.next);
        slow.next = null; // remove link to the second half
        slow = head;// Currently slow is at half the distance..Reset slow to head;

        // Reorder
        while (slow != null && fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next; // We can reset fast to the next node in fast
            slow.next.next = temp;
            slow = temp;// reset slow to slowTemp
        }
    }

    private ListNode reverseTheLinkListNode(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}