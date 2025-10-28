/**
 * Leet Code : https://leetcode.com/problems/reorder-list/submissions/1813907100/
 *
 * Approaches:
 *
 * 1. Iterative Approach (reorderList):
 *    - Use fast and slow pointers to find the middle of the list.
 *    - Reverse the second half of the list.
 *    - Merge the two halves by alternating nodes from each half.
 *
 * 2. Recursive Approach (reorderList1):
 *    - Use recursion to reach the end of the list.
 *    - On unwinding, rearrange pointers to interleave nodes from the start and end.
 *    - Stop when pointers meet or cross.
 */
public class ReorderList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHead = reverse(slow.next);
        slow.next = null;

        ListNode currentA = head;
        ListNode currentB = reverseHead;

        while (currentA != null && currentB != null) {
            ListNode temp1 = currentA.next;
            currentA.next = currentB;
            ListNode temp2 = currentB.next;
            currentB.next = temp1;
            currentA = temp1;
            currentB = temp2;
        }
    }

    private ListNode current;
    private boolean done = false;

    public void reorderList1(ListNode head) {
        current = head;
        helper(head);
    }

    private void helper(ListNode node) {
        if (node == null || done == true) return;

        helper(node.next);
        if (!done) {
            if (current == node) {
                current.next = null;
                done = true;
            } else if (current.next == node) {
                current.next.next = null;
                done = true;
            }else {
                ListNode temp = current.next;
                current.next = node;
                node.next = temp;
                current = temp;
            }
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode previous = null;
        ListNode current = node;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;
        //four.next = five;
        new ReorderList().reorderList1(one);
    }
}
