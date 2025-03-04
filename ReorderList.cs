//Time complexity - O(n)
// space complexity - O(1)
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
// Approach - Get moddle node of List
//     Reverse the second half of the linked list 
//     merge first half anf second helf
public class Solution
{
    public void ReorderList(ListNode head)
    {
        // get middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // merge two linled lists
        fast = prev;
        slow = head;

        while (fast != null)
        {
            ListNode temp1 = slow.next;
            ListNode temp2 = fast.next;

            slow.next = fast;
            fast.next = temp1;

            slow = temp1;
            fast = temp2;
        }
    }
}