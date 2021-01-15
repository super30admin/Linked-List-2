/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// TC: O(1)
// SC: O(1)
// Did ir run successfully on Leetcode? : Yes
class Solution {
    public void deleteNode(ListNode node) {
        // copy the value of next node's value
         node.val = node.next.val;
        // delete the next node
         node.next = node.next.next;
    }
}
