/**
Problem: Delete a node from the linked list without any reference to its head
Did it run on LeetCode: Couldn't find it on LeetCode

Time Complexity: O(1), as we don't have the head pointer to traverse, we just update the current node
Space Complexity : O(1)

Approach:
1. First, update the current node's value to be equal to the next node's value.
2. Next, we need to update the current node's next pointer to be pointing to the next node's next value
3. This would remove the connection. Also, we must update the connection of prev.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Solution {
     public void delete(ListNode node) {
         node.val = node.next.val;
         node.next = node.next.next;
     }
 }