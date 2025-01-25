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

/*
    Leetcode problem 146: Reorder List
    T.C: O(n) :: S.C: O(1) - Amortized T.C

    Solved using two pointers: fast and slow, Position the slow pointer into the middle of the linked List.
    Split the Linked list to two halves. Reverse the second half of Linked list (slow.next - write a 
    helper method). Re-order the Linked list from the split halves (i.e point the head's next to the head
    of the reversed list and then this next to node back to the initial next node in the LL). Congrats problem solved!
*/

class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode fast = head;
        ListNode slow = head;

        //Position the slow pointer to the middle of the linked List
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //Split the Linked list to two halves
        fast = slow.next;
        slow.next = null;

        //Reverse the second half of Linked list
        fast = reverseList(fast);

        //Re-order the Linked list from the split halves
        slow = head;
        ListNode temp = slow.next;

        while (fast != null) {
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
            if (temp != null) temp = temp.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode fast = head.next;
        ListNode curr = head;

        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;

        return curr;
    }
}