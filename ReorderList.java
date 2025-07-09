// Time Complexity: O(n)
//   - Finding the middle takes O(n/2)
//   - Reversing the second half takes O(n/2)
//   - Merging the two halves takes O(n)
//   - Total = O(n)
// Space Complexity: O(1)

// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// Use fast and slow pointers to find the middle of the list.
// Reverse the second half of the list starting from slow.next.
// Merge the first half (ptr1) and the reversed second half (ptr2) node by node.
// The slow.next is set to null to split the list into two parts before merging.
// The merge is done by alternating nodes from each half until ptr2 is exhausted.

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
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = reverse(slow.next);
        slow.next = null;

        while(ptr2 != null){
            ListNode temp = ptr1.next;
            ptr1.next = ptr2;
            ptr2 = ptr2.next;
            ptr1.next.next = temp;
            ptr1 = temp;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}