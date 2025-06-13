// Time Complexity : O(n), n = size of linked lists.
// Space Complexity : O(1) — no extra space used, just few reference pointers.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : YES


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
class ReorderList_LC143 {
    public void reorderList(ListNode head) {

//        Step 1: Find the middle (slow and fast pointers)

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode tmp = curr.next; // Step 1: store the next node
            curr.next = prev;         // Step 2: reverse the current node’s pointer
            prev = curr;              // Step 3: move prev forward
            curr = tmp;               // Step 4: move curr forward
        }

        ListNode first = head;
        ListNode second = prev;
        while (first != null && second != null) {
            ListNode tmpHead = first.next;
            ListNode tmpPrev = second.next;
            
            first.next = second;
            if (tmpHead == null) break;
            second.next = tmpHead;

            first = tmpHead;
            second = tmpPrev;
        }

    }
}