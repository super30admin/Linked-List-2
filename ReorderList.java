// O(n) time, O(1) space
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }
        int mid = len / 2;
        for (int i = 0; i < mid; i++) {
            slow = slow.next;
        }
        // now slow is at mid;

        fast = reverse(slow.next); // reverse 2nd half (mid+1 == slow.next)
        // now fast is at head of reversed list

        slow.next = null; // remove connection in between

        slow = head;

        while (slow != null && fast != null) {
            ListNode temp1 = slow.next;
            slow.next = fast;
            ListNode temp2 = fast.next;
            fast.next = temp1;

            slow = temp1;
            fast = temp2;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    } 
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}