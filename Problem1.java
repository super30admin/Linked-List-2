/** Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

// Time Complexity : O(n)
// Space Complexity : O(1) constant space as its in place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//approach-Because the problem requires "in-place" operations, we can only change their pointers, not creating a new list. This problem can be solved by doing the following 3 steps:
//1. Break list in the middle to two lists (use fast & slow pointers)
//2. Reverse the order of the second list
//3. Merge two list back together

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //finding the middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode temp;
        while(slow != null && fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        while(next != null){
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        return current;
    }
}