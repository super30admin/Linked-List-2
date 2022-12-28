public class Reorder_list {
    // Time: O(n): O(n)+O(n/2)+O(n/2), Space: O(1)
    public void reorderList(ListNode head) {

        // find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half
        ListNode second = reverse (slow);

        // merge the two lists
        ListNode first = head, tmp;

        while (second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }

    ListNode reverse (ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }
}
