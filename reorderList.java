// Time Complexity = O(n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find the mid point of the LL
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the LL
        fast = reverse(slow.next);
        slow.next = null;   // Break the two lists, otherwise there will be a loop

        // 3. Merge the 2 lists together
        slow = head;
        ListNode dummy = slow.next;

        while (fast != null) {
            slow.next = fast;
            fast = fast.next;
            slow.next.next = dummy;
            slow = dummy;
            if (dummy == null) {
                break;
            }
            dummy = dummy.next;
        }

    }

    // Reversing the LL
    private ListNode reverse(ListNode head) {
        ListNode prev=null, curr=head, fast=head.next;
        if (head == null || head.next == null) return head;

        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;

        return curr;
    }
}