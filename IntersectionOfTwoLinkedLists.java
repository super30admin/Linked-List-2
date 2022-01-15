/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Time Complexity : O(n+m), where n is the length of LL A and m is the length of LL B
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach : In the first iteration, we reset the pointer of one linkedlist to the head of another
    // linkedlist after it reaches the tail node. In the second iteration, we will move two pointers until they points
    // to the same node.

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        if(tempA == null) {
            tempA = headB;
            while(tempB != null) {
                tempB = tempB.next;
                tempA = tempA.next;
            }
            tempB = headA;
        } else {
            tempB = headA;
            while(tempA != null) {
                tempB = tempB.next;
                tempA = tempA.next;
            }
            tempA = headB;
        }

        while(tempA != tempB) {
            tempB = tempB.next;
            tempA = tempA.next;
        }

        return tempA;
    }
}