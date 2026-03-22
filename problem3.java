    /**
    Time Complexity : O(1)
    Explanation:
    We directly modify the given node by copying the next node’s value
    and bypassing it. No traversal is needed.

    Space Complexity : O(1)
    Explanation:
    No extra space is used.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially thought we needed access to the previous node to delete,
    but this problem guarantees that the node to be deleted is not the tail.
    So we can copy the next node’s value and skip it instead of actual deletion.
    */

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

        ListNode temp = node.next;

        // Copy next node's value
        node.val = temp.val;

        // Skip next node
        node.next = node.next.next;

        // Optional cleanup
        temp.next = null;
    }
}