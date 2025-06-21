// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
public class DeleteHeadWithoutPointer {

    static class ListNode1 {
        int data;
        ListNode1 next;

        ListNode1(int val) {
            this.data = val;
            this.next = null;
        }
    }

    static void deleteNode(ListNode1 node) {
        if (node == null || node.next == null) {
            System.out.println("Cannot delete the last node or a null node using this method.");
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }

    static void printList(ListNode1 head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);

        System.out.println("Before deletion:");
        printList(head);
        int val = head.next.next.data;
        deleteNode(head.next.next);

        System.out.println("After deleting node with value "+ val + " :");
        printList(head);
    }
}
