// Time Complexity :O(n/2) + O(n/2) + O(n) ~ O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
First I found out the half of the linked list. Then I reversed the second half.
Once I reversed the second half, I merged both the list till the second list pointer is not null.
*/


public class Problem2 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverse(slow.next);
        slow.next = null;

        slow = head;
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            ListNode fastTemp = fast.next;
            fast.next = temp;
            slow = temp;
            fast = fastTemp;
        }

    }

    private ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
