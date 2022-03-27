/*
// Time Complexity : O(n)  :  Total Time complexity :   for finding the midddle O(n) + for reversing the half list  O(n/2) + changing the pointer O(n). 
Total :  O(n) + O(n/2) + O(n)  = O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
  
  */

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution_reorderlist {

    public void reorderList(ListNode head) {

        ListNode first = head;
        ListNode sec = head;
        // fast and slow pointers for finding the middle.
        while (first != null && first.next != null) {

            first = first.next.next;
            sec = sec.next;

        }
        // reversed list;
        ListNode reverse = reverse1(sec);

        first = head;
        // changing the pointers in the linklist.
        while (reverse.next != null) {
            // storing the next pointer.

            ListNode temp = first.next;
            // changing the pointer to the next half

            first.next = reverse;
            // changing the first to to next
            first = temp;

            // storing the next pointer.
            temp = reverse.next;

            // changing the pointer to the next half

            reverse.next = first;
            // changing the reverse to to next
            reverse = temp;

        }

    }

    // reversing the list.
    public ListNode reverse1(ListNode head) {

        ListNode prev = null;

        while (head != null) {

            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}
