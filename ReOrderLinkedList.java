public class ReOrderLinkedList {
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

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondList = reverse(slow.next);
        slow.next = null;
        ListNode current = head;
        while (secondList != null) {
            ListNode temp = current.next;
            current.next = secondList;
            secondList = secondList.next;
            current.next.next = temp;
            current = temp;

        }

    }

    private ListNode reverse(ListNode middle) {
        ListNode before = null;
        ListNode tmp = middle;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = before;
            before = tmp;
            tmp = next;
        }
        middle = before;
        return middle;
    }
}
