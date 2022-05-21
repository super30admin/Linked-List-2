// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        int mid = 0;
        ListNode slow = head;
        ListNode fast = head;
        // finding Middle node with slow pointer
        // fast.next added for odd number of nodes
        // fast.next.next added for even number of nodes
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseListFrom = slow.next;
        // disconnecting the next of mid, as that's going to be the last node in the result
        slow.next = null;
        ListNode curr = reverseListFrom;
        ListNode prev = null;
        // reversing the LL from next of mid
        while(curr != null) {
            ListNode nextCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextCurr;
        }

        // now merging head to mid LL and reversed LL in a zigzag manner
        while(head != null && prev != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = prev.next;
            head.next.next = temp;
            head = temp;
        }

    }
}