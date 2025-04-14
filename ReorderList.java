package week4;

public class ReorderList {

    class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;

        }
    }

    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        //find middle
        while(fast !=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse second half
        ListNode revHalfHead = reverse(slow.next);
        slow.next = null;

        //merge
        slow = head;
        fast = revHalfHead;
        while(fast != null) {
            // 1 2 3
            // 6 5 4
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
