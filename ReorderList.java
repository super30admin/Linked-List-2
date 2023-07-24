package LinkedListII;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class ReorderList {

    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null)  //find the middle  //O(n/2)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHead = reverse(slow.next); // O(n/2)
        slow.next = null;
        slow = head;
        fast = reverseHead;

        while(fast!= null)      // O(n/2)
        {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }


    }

    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
