//SC is O(1)
//TC is O(n)
class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of linked list
        fast = reversed(slow.next);

        // break and merge list
        // fast is head of second list

        slow.next = null;
        slow = head;

        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    private ListNode reversed(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next;

        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;

        }
        // setting the last pointer
        curr.next = prev;

        return curr;
    }
}