// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * we are guaranteed that the node to be deleted is not the last node in the list.
 * So we can easily copy the next node value in current node
 * we can then point the cur node's next pointer to the next to next node
 */


class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

