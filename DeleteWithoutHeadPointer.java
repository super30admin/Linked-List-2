/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;

        if(null != temp) {
            node.val = temp.val;
            node.next = temp.next;
        }

    }
}