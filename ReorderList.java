/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 * Approach:
 * 1. Split the list from middle
 * 2. reverse the second part
 * 3. merge the two lists
 */
public class ReorderList {

    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1. Split the list into 2 halves
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the linkedList of part 2
        fast = reverseList(slow.next);
        slow.next = null;

        slow = head;
        // 3. merge the two lists
        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next;

        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;

        return curr;
    }
}
