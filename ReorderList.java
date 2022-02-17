public class ReorderList {

    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode head2 = null;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        // merge
        while (head2 != null) {
            ListNode temp = head.next;
            head.next = head2;
            head2 = head2.next;
            head.next.next = temp;
            head = temp;

        }

    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;
    }

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
}
