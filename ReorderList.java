// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/*

We iterate and reach till the middle of the linked list.
Once we reach, we reverse the second half of the LL.
We treat them both as seperate lists and connect them accordingly.

*/
public class ReorderList
{
    public static void reorderList(ListNode head)
    {
        if(head==null || head.next == null)
        {
            return;
        }

        ListNode slow = head, fast = head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast=fast.next.next;
        }


        fast = reverse(slow.next);
        slow.next = null;

        slow = head;
        ListNode temp = null;

        while(fast!=null)
        {
            temp = slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow = temp;
        }
    }


    public static ListNode reverse(ListNode head)
    {
        if(head==null || head.next == null)
        {
            return head;
        }

        ListNode prev = null,curr = head,fast = head.next;

        while(fast!=null)
        {
            curr.next=prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }

        curr.next=prev;

        return curr;
    }

}