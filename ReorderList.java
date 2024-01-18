public class ReorderList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    // TC: O(N) where N is length linked list
    // SC: O(1)
    public void reorderList(ListNode head) {
        ListNode middle = getMiddleNode(head);
        ListNode secondHalf = middle.next;
        middle.next = null;
        ListNode reversedSecondHalf = reverse(secondHalf);
        ListNode p1 = head, p2 = reversedSecondHalf;
        while (p1 != null && p2 != null) {
            ListNode p1Next = p1.next;
            p1.next = p2;

            p1 = p2;
            p2 = p1Next;
        }
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        return prev;
    }
}
