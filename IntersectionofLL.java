// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// made pass throught the lists to get the lengths
// Traversed through the lists till they were of the same length
// go the node from where were equal

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
        if (headA == null || headB == null)
            return null;
        ListNode curr = headA;
        int lenA = 0, lenB = 0;
        while (curr != null) {
            curr = curr.next;
            lenA++;
        }

        curr = headB;
        while (curr != null) {
            curr = curr.next;
            lenB++;
        }

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }
}