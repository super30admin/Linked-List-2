// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse second half
        fast = reverse(slow.next);
        slow.next = null;

        // merge the two parts of original list
        slow = head;
        ListNode temp;

        while (fast != null) {
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        // slow.next = fast;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode currNext;

        while (curr != null) {
            currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;

        }

        return prev;

    }
}