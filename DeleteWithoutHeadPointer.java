// Approach: We only need to delete the value, not the given node itself. Copy the value of the next node into the given node and update
// the given node's next pointer to skip the next node, effectively removing it from the list while preserving its value.
// Time Complexity: O(1)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1

public class DeleteWithoutHeadPointer {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int v) {
            val = v;
        }
    }

    void deleteWithoutHead(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print("NULL\n");
    }

    public static void main(String[] args) {
        DeleteWithoutHeadPointer dwhp = new DeleteWithoutHeadPointer();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println("List before deleting..");
        dwhp.printLL(head);
        dwhp.deleteWithoutHead(head.next);
        System.out.println("List after deleting..");
        dwhp.printLL(head);
    }
}