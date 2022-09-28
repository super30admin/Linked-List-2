// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * There are 3 steps to solve this problem - 1) Find the midpoint of the LL 2) Reverse the LL after the 
 * midpoint 3) Merge the 2 LL. For even and odd, condition of fast differs so be mindful of that.
 */
//143. Reorder List (Medium) - https://leetcode.com/problems/reorder-list/
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while(fast != null)
        {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while(fast != null)
        {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}