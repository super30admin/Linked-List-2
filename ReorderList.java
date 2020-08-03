/**
Problem : Reorder the linkedlist
Did it run on LeetCode: Yes

Time Complexity : O(n), where n is the number of nodes in the linkedlist.
Space Complexity: O(1)

Approach : 
1. First, find the middle of the linked list.
2. Then, reverse the second half of the list
3. And later, merge two lists(use two pointers for this).
*/

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
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;
        ListNode curr;
        while(fast != null) {
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}