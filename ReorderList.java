// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ReorderList {
    int size = 0;
    public void reorderList(ListNode head)
    {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;

        while(fast != null)
        {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = slow.next.next;
            slow = temp;
        }
    }

    public ListNode reverseList(ListNode curr)
    {
        ListNode prev = null;

        while(curr != null)
        {
            size++;
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
