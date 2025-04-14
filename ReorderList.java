class ListNode {
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

// TC: O(n): for traversing the all nodes to find the middle node
// SC: O(n): using the recursion stack for reversing half length ndoes.

// First the middle node is found, then the next nodes are reversed and then
// merged.
public class ReorderList {
    static ListNode head;

    public static void main(String[] args) {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        slow = head;
        fast = reversed(secondHalf);
        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    private static ListNode reversed(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = reversed(head.next);
        head.next.next = head;
        head.next = null;
        return current;

    }

}
