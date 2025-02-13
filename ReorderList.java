// Approach: Find the midpoint of the given list using the slow and fast pointers technique. Reverse the second half of the list.
// Merge the two halves alternately.
// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/reorder-list/description/

public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int v) {
            val = v;
        }
    }

    void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null, curr = slow.next, nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Merge both halves alternatively.
        slow.next = null;
        ListNode first = head, second = prev, end = head;
        first = first.next;

        boolean flag = true;
        while (first != null && second != null) {
            if (flag) {
                end.next = second;
                second = second.next;
            } else {
                end.next = first;
                first = first.next;
            }
            end = end.next;
            flag = !flag;
        }
        if (first != null) {
            end.next = first;
        } else {
            end.next = second;
        }
    }

    void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL\n");
    }

    public static void main(String[] args) {
        ReorderList rol = new ReorderList();

        // Input: head = [1,2,3,4,5]
        // Output: [1,5,2,4,3]

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("List before reordering..");
        rol.printLL(head);

        rol.reorderList(head);

        System.out.println("List after reordering..");
        rol.printLL(head);
    }
}