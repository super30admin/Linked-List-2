/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution
{
    public void ReorderList(ListNode head)
    {
        if (head == null)
        {
            return;
        }
        //Split into half 
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse other half
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = Reverse(head2);

        //Merge 2 lists
        ListNode temp = head.next;
        slow = head;
        while (head2 != null)
        {
            temp = slow.next;
            slow.next = head2;
            head2 = head2.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    public ListNode Reverse(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;

        while (next != null)
        {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        return current;
    }
}