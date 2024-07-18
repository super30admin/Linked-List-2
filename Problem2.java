//Time = O(n)
/*
Finding the middle node of the linked list: O(n)
Reversing the second half of the linked list: O(n/2)
Merging the first and second halves of the linked list: O(n/2)
Overall, the time complexity of the algorithm is O(n). */

//Space = O(1)

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
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return;
        }
        
        // Find the middle node of the linked list
        ListNode slow = head; // slow pointer
        ListNode fast = head; // fast pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Merge the first and second halves of the linked list
        ListNode p1 = head; // pointer to the first half of the list
        ListNode p2 = prev; // pointer to the reversed second half of the list
        while (p2 != null) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
    }
}
