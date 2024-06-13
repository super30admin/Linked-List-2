// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        int count = 0;
        ListNode dummy = new ListNode(-1); // creating dummy in case n = length of list
        dummy.next = head; // linking it back to our list
        ListNode fast = dummy; // fast pointer
        ListNode slow = dummy; // slow pointer

        while(count <= n){ // to create gap between fast and slow
            fast = fast.next;
            count = count + 1;
        }

        while(fast != null){ // finding the node to remove
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next; // increment

    }
}