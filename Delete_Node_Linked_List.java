
// Time Complexity :O(1)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



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
      ListNode nextNode = node.next;
      node.val = nextNode.val;
      node.next = nextNode.next;
      nextNode.next= null;
    }
}
