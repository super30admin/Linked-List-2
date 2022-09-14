//Problem3 - https://leetcode.com/problems/delete-node-in-a-linked-list/

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class Problem3 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
