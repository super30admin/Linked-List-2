/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Idea is as follows:
 * 1. get to the middle of the linked list
 * 2. reverse the later half of the linked list
 * 3. now we have the first half, and the reversed second half, start interleaving them.
 * 
 * Space Complexity: O(1)
 * Time Complexity: O(n)
 * 
 * Number of Leetcode Attempts: 3
 * 
 * Leetcode Result:
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reorder List.
 * Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Reorder List.
 */
public class ReorderList {
    /**
     * 
     * @param head 
     */
    public void reorderList(ListNode head) {
        // get to middle of the linked list
        ListNode mid = partition(head);
        if(mid == null) {
            return;
        }
        // reverse the later half.
        ListNode second = reverse(mid.next);
        mid.next = null; // break link joining these 2 halves.

        // pointer rearrangement, we are now interleaving the nodes.
        ListNode cursor1 = head, cursor2 = second;
        ListNode next1, next2;
        while(cursor1 != null && cursor2 != null) {
            next1 = cursor1.next;
            next2 = cursor2.next;
            cursor1.next = cursor2;
            cursor2.next = next1;
            cursor1 = next1;
            cursor2 = next2;
        }
    }
    
    /**
     * 
     * @param head
     * @return node at which the second half of linked list starts.
     */
    private ListNode partition(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    /**
     * 
     * @param head
     * @return head to reversed linkedlist
     */
    private ListNode reverse(ListNode head) {
        ListNode reverseHead = null;
        ListNode cursor = head;
        ListNode next;
        while(cursor != null) {
            next = cursor.next;
            cursor.next = reverseHead;
            reverseHead = cursor;
            cursor = next;
        }
        return reverseHead;
    }
}