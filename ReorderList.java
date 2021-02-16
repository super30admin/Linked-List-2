// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;

        // find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse later part

        fast = reverse(slow.next);
        slow.next = null;

        // combine

        slow = head;

        while (fast != null && slow != null) {
            ListNode nextS = slow.next;
            ListNode nextF = fast.next;

            slow.next = fast;
            fast.next = nextS;

            slow = nextS;
            fast = nextF;

        }
    }
}