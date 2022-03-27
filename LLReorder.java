// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        //find middle of the list - we want to half the list

        ListNode slow = head;
        ListNode fast = head;

        //condition 1 for odd list and 2 for even list
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow is now at the middle and fast at end

        //reverse the second half and point fast to it's head
        fast = reverse(slow.next);

        //severe the two lists now
        slow.next = null;

        //put slow at head of first half
        slow = head;

        //merge the two halves
        while(fast != null)
        //this condition is good for both odd and even because second half will always be shorten than or same length as first half so fast will finish together with slow or before it
        {
            //explaination in notes
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    public ListNode reverse(ListNode head)
    {
        ListNode previous = null;
        ListNode current = head;
        ListNode fast = head.next;

        while(fast != null)
        {
            current.next = previous;
            previous = current;
            current = fast;
            fast = fast.next;
        }

        current.next = previous;

        return current;
    }
}
