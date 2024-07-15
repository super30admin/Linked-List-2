// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



class Solution {
    public void deleteNode(ListNode node) {
        // Store the next node in a temporary variable
        ListNode temp = node.next;

        // Copy the value of the next node to the current node
        node.val = temp.val;

        // Link the current node to the node after the next node, effectively removing the next node
        node.next = node.next.next;

        // Optional: Clear the next reference of the removed node
        temp.next = null;
    }
}
