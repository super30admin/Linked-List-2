// TC: O(n)
// SC: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        // find middle
        // reverse second half
        // merge
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast, slow;
        fast = dummy;
        slow = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode third, second, first;
        second = null;
        first = slow.next;
        slow.next = null;
        while(first != null) {
            third = first.next;
            first.next = second;
            second = first;
            first = third;
        }

        ListNode curr = head;
        while(second != null) {
            ListNode temp = curr.next;
            curr.next = second;
            curr = curr.next;
            second = second.next;
            curr.next = temp;
            curr = curr.next;
        }
    }
}