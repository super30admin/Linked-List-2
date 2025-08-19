// Time Complexity : O(n) — find middle O(n), reverse O(n), merge O(n)
// Space Complexity : O(1) — in-place reversal and merge, only a few pointers
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach:
// 1) Find the middle using slow/fast pointers. After the loop, slow is at the end of the first half.
// 2) Reverse the second half starting from slow.next.
// 3) Cut the list at slow (slow.next = null) to split first and second halves.
// 4) Merge the first half and the reversed second half alternately.

public class ReOrderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1) Find middle (slow ends at middle for odd, end of first half for even)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Reverse second half (starts at slow.next)
        ListNode second = reverse(slow.next);

        // 3) Split the list
        slow.next = null;

        // 4) Merge two halves: head (first), second (reversed)
        ListNode first = head, s = second;
        while (s != null) {
            ListNode t1 = first.next; // save next of first
            ListNode t2 = s.next;     // save next of second

            first.next = s;           // link first → second
            s.next = t1;              // link second → next of first

            // advance
            first = t1;
            s = t2;
        }
    }

    // Reverse a singly linked list (iterative)
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        // Example 1: odd length: 1->2->3->4->5  => 1->5->2->4->3
        ListNode h1 = fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original (odd):");
        printList(h1);
        new ReOrderList().reorderList(h1);
        System.out.println("Reordered (odd):");
        printList(h1);

        // Example 2: even length: 1->2->3->4  => 1->4->2->3
        ListNode h2 = fromArray(new int[]{1, 2, 3, 4});
        System.out.println("\nOriginal (even):");
        printList(h2);
        new ReOrderList().reorderList(h2);
        System.out.println("Reordered (even):");
        printList(h2);

        // Example 3: small lists
        ListNode h3 = fromArray(new int[]{1});
        new ReOrderList().reorderList(h3); // unchanged
        System.out.println("\nSingle node:");
        printList(h3);

        ListNode h4 = fromArray(new int[]{1, 2});
        new ReOrderList().reorderList(h4); // 1->2 stays 1->2
        System.out.println("Two nodes:");
        printList(h4);
    }

    // Helpers
    private static ListNode fromArray(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }
}
