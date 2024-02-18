// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode tempA = headA;
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        if (lenB > lenA) {

            for (int i = 0; i < lenB - lenA; i++) {
                tempB = tempB.next;
            }

            for (int i = 0; i < lenA; i++) {
                if(tempA == tempB) {
                    return tempA;
                }
                tempB = tempB.next;
                tempA = tempA.next;
            }
            
        } else {
             for (int i = 0; i < lenA - lenB; i++) {
                tempA = tempA.next;
            }

            for (int i = 0; i < lenB; i++) {
                if(tempA == tempB) {
                    return tempA;
                }
                tempB = tempB.next;
                tempA = tempA.next;
            }
        }

        return null;
    }
}