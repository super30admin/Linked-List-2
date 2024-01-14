// Time Complexity : O(1)
// Space Complexity : O(1)
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
        //ListNode temp1 = node;
        ListNode curr = node.next;

        node.val = curr.val;   //copy the val of next element to the node that we have delete..
        //then delete that node
        node.next = curr.next;
        curr.next = null;
    }
}