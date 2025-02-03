// We are breaking this problem into 3 steps: 
// 1. Find the mid of LL and break it from the mid and create 2 LL. 
// 2. Then reverse the second LL
// 3. Merge the 2 LL by using pointers

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public void reorderList(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return;
        }
        // Find mid
        ListNode slow = head;
        ListNode fast = head;
        // Slow will stop at mid when fast.next = null or fast.next.next = null
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Now the head of second LL is in slow.next. So pass it to the reverse function
        // to reverse the second LL and give its head to the fast
        fast = reverse(slow.next);
        // Set slow.next to null to end the first LL at mid i.e. slow
        slow.next = null;
        // Reset slow to head(so head of first LL)
        slow = head;
        // Go on until fast!=null
        while (fast != null) {
            // Store slow.next in temp
            ListNode t = slow.next;
            // Modify or point slow.next to fast
            slow.next = fast;
            // Then fast will increment to fast.next
            fast = fast.next;
            // Slow.next.next will be temp(t)
            slow.next.next = t;
            // Increment slow to t
            slow = t;
        }
    }

    // Reverse using 3 pointers
    private ListNode reverse(ListNode n) {
        ListNode prev = null;
        ListNode curr = n;
        ListNode fast = curr.next;
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