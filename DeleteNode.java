// Time Complexity : The time complexity is O(1)
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        // Since the head is not given, make the value of the node equal to the next node and change the next to next's next.
        ListNode next = node.next;
        node.val=next.val;
        node.next=node.next.next;

    }
}