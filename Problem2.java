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

/**
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void reorderList(ListNode head) {
        /**
         1. Go to the mid
         2. Reverse the list after the mid
         3. Reorder the list
         **/

        if(head==null||head.next==null) return;

        ListNode slow = head;
        ListNode fast = head;

        // Put slow pointer at mid
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse from mid+1
        ListNode reverseHead = reverse(slow.next);

        // Reorder
        slow.next = null;
        slow = head;
        while(reverseHead!=null)
        {
            ListNode temp = slow.next;
            slow.next = reverseHead;
            reverseHead = reverseHead.next;
            slow.next.next = temp;
            slow = temp;
        }
        if(slow!=null)
            slow.next = reverseHead;
    }

    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast!=null)
        {
            curr.next=prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}