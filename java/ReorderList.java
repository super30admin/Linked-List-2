package java;

public class ReorderList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head, fast = head;
        //find mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedHead = reverse(slow.next);
        slow.next = null;

        slow = head;
        fast = reversedHead;

        while (fast != null) {
            ListNode tmp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = tmp;
            slow = tmp;
        }
    }

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
}

//TC: O(n)
//SC: O(1)
