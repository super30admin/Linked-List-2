// TC: O(n)
// SC: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow, fast;
        //find middle
        slow = head;
        fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse second half
        fast = slow.next;
        slow.next = null;
        ListNode prev;
        prev = null;
        slow = null;
        while(fast != null) {
            prev = slow;
            slow = fast;
            fast = fast.next;
            slow.next = prev;
        }
        //merge
        ListNode temp;
        prev = null;
        while(head != null && slow != null) {
            prev = head.next;
            temp = slow.next;
            head.next = slow;
            slow.next = prev;
            slow = temp;
            head = prev;
        }
    }
}