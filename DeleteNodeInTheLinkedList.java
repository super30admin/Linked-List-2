/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Start from the node to be deleted and then start copying values from the next node until the node which is to be deleted reached the end of the list. Then with the help of the previous pointer remove the node
*/
class Solution {
    public void deleteNode(ListNode node) {

        ListNode prev = null;
        while(node.next != null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }

        prev.next = null;

    }
}