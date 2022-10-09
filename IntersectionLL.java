// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // base case
        if (headA == null || headB == null) return null;

        int lenA = 0, lenB = 0;
        ListNode curr = headA;

        // Calculate length of headA LL
        while (curr!=null) {
            curr = curr.next;
            lenA++;
        }

        // Calculate length of headB LL
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
