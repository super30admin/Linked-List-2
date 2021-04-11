// Time Complexity : O(n); n = #nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class ListNode
{
    int val ;
    ListNode next;
    ListNode(int d)
    {
        val = d;
        next = null;
    }
}
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while (fast != null && slow != null) {
            ListNode sNext = slow.next;
            ListNode fNext = fast.next;

            slow.next = fast;
            fast.next = sNext;

            fast = fNext;
            slow = sNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
