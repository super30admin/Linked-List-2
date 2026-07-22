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
    /*
        TC - O(n)
        SC - O(1)
        
        First step is to find the middle of the list using the slow and fast pointer technique.
        - When the loop ends, slow points to the middle node.
        Second step is to reverse the second half. 
        - Reverse the linked list starting from slow.next.
        - Disconnect the first half by setting slow.next = null.
        Third step us to merge the two halves
        - Start with one pointer at the beginning of the first half and another at the head of the reversed 
        second half.
        - Alternately link nodes from each half until the second half is exhausted.
    */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        ListNode prev = null;

        while (fast != null) {
            ListNode temp = fast.next;
            fast.next = prev;
            prev = fast;
            fast = temp;
        }

        slow.next = null;
        slow = head;
        fast = prev;

        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
}